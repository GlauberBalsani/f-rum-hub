package com.balsani.forum.domain.curso.model.dto;

import com.balsani.forum.domain.curso.model.Categoria;
import com.balsani.forum.domain.curso.model.Curso;

public record CursoResponseDTO(
        String nome,
        Categoria categoria
) {
    public CursoResponseDTO(Curso curso) {
        this(curso.getNome(), curso.getCategoria());
    }
}
