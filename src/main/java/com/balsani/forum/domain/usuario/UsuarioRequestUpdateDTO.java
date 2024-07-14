package com.balsani.forum.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestUpdateDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email) {

    public static UsuarioRequestUpdateDTO toModel(Usuario usuario) {
        return new UsuarioRequestUpdateDTO(
                usuario.getNome(),
                usuario.getEmail()
        );
    }
}
