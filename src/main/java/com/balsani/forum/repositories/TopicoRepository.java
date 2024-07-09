package com.balsani.forum.repositories;

import com.balsani.forum.domain.forum.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
