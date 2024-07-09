package com.balsani.forum.domain.forum.model;

import com.balsani.forum.domain.usuario.model.dto.UsuarioRequestDTO;

import java.time.LocalDateTime;

public record TopicoRequestDTO(
        String titulo,
        String mensagem,
        Status status,
        UsuarioRequestDTO autor


) {
}
