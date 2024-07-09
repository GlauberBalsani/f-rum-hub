package com.balsani.forum.repositories.curso;

public record CursoResponseDTO(
        String nome,
        Categoria categoria
) {
    public CursoResponseDTO(Curso curso) {
        this(curso.getNome(), curso.getCategoria());
    }
}
