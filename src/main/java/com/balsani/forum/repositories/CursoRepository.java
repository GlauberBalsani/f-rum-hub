package com.balsani.forum.repositories;

import com.balsani.forum.repositories.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
     boolean existsCursoByNome(String nome);
}
