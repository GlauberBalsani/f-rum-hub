package com.balsani.forum.controller;

import com.balsani.forum.domain.curso.CursoRequestDTO;
import com.balsani.forum.domain.forum.TopicoRequestDTO;
import com.balsani.forum.services.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topicos")
public class TopicoController {
    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<TopicoRequestDTO> create(@RequestBody @Valid TopicoRequestDTO topicoRequestDTO,
                                                  UriComponentsBuilder builder) {
        var topico = topicoService.create(topicoRequestDTO);
        var uri = builder.path("/cursos/{nome}").buildAndExpand(topico.titulo()).toUri();
        return ResponseEntity.created(uri).body(topicoRequestDTO);

    }


}
