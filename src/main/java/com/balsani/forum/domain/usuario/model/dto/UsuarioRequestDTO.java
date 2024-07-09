package com.balsani.forum.domain.usuario.model.dto;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha
) {
}
