package com.balsani.forum.domain.forum;

import com.balsani.forum.domain.curso.Curso;
import com.balsani.forum.domain.curso.CursoRequestDTO;
import com.balsani.forum.domain.usuario.UsuarioRequestDTO;
import jakarta.validation.constraints.NotBlank;

public record TopicoRequestDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String curso


) {
        public static TopicoRequestDTO toModel(Topico topico) {
                return new TopicoRequestDTO(
                        topico.getTitulo(),
                        topico.getMensagem(),
                        topico.getCurso().getNome()
                );
        }
}
