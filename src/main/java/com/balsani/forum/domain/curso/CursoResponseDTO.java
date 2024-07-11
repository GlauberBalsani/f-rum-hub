package com.balsani.forum.domain.curso;

public record CursoResponseDTO(
        String nome,
        Categoria categoria
) {
    public CursoResponseDTO(Curso curso) {
        this(curso.getNome(), curso.getCategoria());
    }
}
