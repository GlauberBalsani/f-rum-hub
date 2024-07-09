package com.balsani.forum.services;

import com.balsani.forum.domain.curso.model.Curso;
import com.balsani.forum.domain.curso.model.CursoRepository;
import com.balsani.forum.domain.curso.model.dto.CursoRequestDTO;
import com.balsani.forum.domain.curso.model.dto.CursoResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CursoRequestDTO create(CursoRequestDTO cursoRequestDTO) {
        if (repository.existsCursoByNome(cursoRequestDTO.nome())) {
            throw new RuntimeException("Curso já cadastrado: " + cursoRequestDTO.nome());
        }
        var curso = new Curso();
        curso.setNome(cursoRequestDTO.nome());
        curso.setCategoria(cursoRequestDTO.categoria());
        repository.save(curso);

        return CursoRequestDTO.toModel(curso);
    }

    public List<Curso> listar() {
        return repository.findAll();
    }

    public CursoResponseDTO getById(Long id) {

        return repository.findById(id)
                .map(CursoResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Curso não encontrada"));
    }
}
