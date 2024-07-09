package com.balsani.forum.domain.curso.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
     boolean existsCursoByNome(String nome);
}
