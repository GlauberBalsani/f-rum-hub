package com.balsani.forum.controller;

import com.balsani.forum.domain.usuario.UsuarioRequestDTO;
import com.balsani.forum.domain.usuario.UsuarioResponseDTO;
import com.balsani.forum.services.UsuarioService;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioRequestDTO> create(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO,
                                                    UriComponentsBuilder builder) {
        var usuario = usuarioService.create(usuarioRequestDTO);
        var uri = builder.path("/cursos/{nome}").buildAndExpand(usuario.nome()).toUri();
        return ResponseEntity.created(uri).body(usuario);

    }

    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> getAll(@PageableDefault(size = 10, sort = {"nome"})Pageable pageable) {
        var page =

    }
}
