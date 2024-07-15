package com.balsani.forum.repositories;

import com.balsani.forum.domain.usuario.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByNome(String nome);
    //Page<Usuario> findAllByAtivoTrue(Pageable pageable);
    boolean findUsuarioByEmail(String nome);
}
