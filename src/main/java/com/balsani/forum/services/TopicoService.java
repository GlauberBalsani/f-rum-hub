package com.balsani.forum.services;

import com.balsani.forum.domain.forum.Topico;
import com.balsani.forum.domain.forum.TopicoRequestDTO;
import com.balsani.forum.repositories.CursoRepository;
import com.balsani.forum.repositories.TopicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;
    private final CursoRepository cursoRepository;

    public TopicoService(TopicoRepository topicoRepository, CursoRepository cursoRepository) {
        this.topicoRepository = topicoRepository;
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public TopicoRequestDTO create(TopicoRequestDTO dadosTopico) {
        var cursoCadastrado = cursoRepository.findCursoByNome(dadosTopico.curso());

        var curso = cursoCadastrado.get();
        var topico = new Topico();
        topico.setTitulo(dadosTopico.titulo());
        topico.setMensagem(dadosTopico.mensagem());
        topico.setCurso(curso);

        topico = topicoRepository.save(topico);

        return TopicoRequestDTO.toModel(topico);
    }
}
