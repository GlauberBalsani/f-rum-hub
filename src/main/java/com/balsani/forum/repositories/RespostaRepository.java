package com.balsani.forum.repositories;

import com.balsani.forum.domain.forum.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
}
