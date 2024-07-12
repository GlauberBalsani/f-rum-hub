package com.balsani.forum.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        String senha
) {

    public static UsuarioRequestDTO toModel(Usuario usuario) {
        return new UsuarioRequestDTO(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }
}
