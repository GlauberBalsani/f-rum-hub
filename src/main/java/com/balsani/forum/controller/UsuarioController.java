package com.balsani.forum.controller;

import com.balsani.forum.domain.usuario.UsuarioRequestDTO;
import com.balsani.forum.domain.usuario.UsuarioResponseDTO;
import com.balsani.forum.repositories.UsuarioRepository;
import com.balsani.forum.services.UsuarioService;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository repository;

    public UsuarioController(UsuarioService usuarioService, UsuarioRepository repository) {
        this.usuarioService = usuarioService;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<UsuarioRequestDTO> create(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO,
                                                    UriComponentsBuilder builder) {
        var usuario = usuarioService.create(usuarioRequestDTO);
        var uri = builder.path("/cursos/{nome}").buildAndExpand(usuario.nome()).toUri();
        return ResponseEntity.created(uri).body(usuario);

    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> getAll(@PageableDefault(size = 10, sort = {"nome"})Pageable pageable) {
        List<UsuarioResponseDTO> usuarios = usuarioService.getAll();
        
        return ResponseEntity.ok(usuarios);

    }
}
