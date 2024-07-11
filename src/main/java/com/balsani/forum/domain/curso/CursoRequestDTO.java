package com.balsani.forum.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CursoRequestDTO(

        @NotBlank
        String nome,
        @NotNull
        Categoria categoria) {

        public static CursoRequestDTO toModel(Curso curso) {
                return new CursoRequestDTO(
                        curso.getNome(),
                        curso.getCategoria()
                );
        }
}
