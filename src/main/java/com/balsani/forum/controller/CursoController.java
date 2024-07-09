package com.balsani.forum.controller;

import com.balsani.forum.repositories.curso.CursoRequestDTO;
import com.balsani.forum.repositories.curso.CursoResponseDTO;
import com.balsani.forum.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoRequestDTO> create(@RequestBody @Valid CursoRequestDTO cursoRequestDTO,
                                                  UriComponentsBuilder builder) {
        var curso = cursoService.create(cursoRequestDTO);
        var uri = builder.path("/cursos/{nome}").buildAndExpand(curso.nome()).toUri();
        return ResponseEntity.created(uri).body(cursoRequestDTO);

    }

    @GetMapping
    public ResponseEntity listar() {
        var cursos = cursoService.listar();
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> getById(@PathVariable Long id) {
        var curso = cursoService.getById(id);

        return ResponseEntity.ok().body(curso);
    }
}
