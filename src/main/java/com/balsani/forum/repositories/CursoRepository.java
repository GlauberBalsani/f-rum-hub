package com.balsani.forum.repositories;

import com.balsani.forum.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
     boolean existsCursoByNome(String nome);

    Optional<Curso> findCursoByNome(String curso);
}
