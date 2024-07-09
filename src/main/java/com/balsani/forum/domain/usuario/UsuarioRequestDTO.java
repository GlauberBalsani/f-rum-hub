package com.balsani.forum.domain.usuario;

public record UsuarioRequestDTO(
        String nome,
        String email,
        String senha
) {
}
