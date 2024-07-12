package com.balsani.forum.services;

import com.balsani.forum.domain.usuario.Usuario;
import com.balsani.forum.domain.usuario.UsuarioRequestDTO;

import com.balsani.forum.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioRequestDTO create(UsuarioRequestDTO usuarioRequestDTO) {
        var usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.nome());
        usuario.setEmail(usuarioRequestDTO.email());
        usuario.setSenha(usuarioRequestDTO.senha());

        usuarioRepository.save(usuario);


        return UsuarioRequestDTO.toModel(usuario);

    }


}
