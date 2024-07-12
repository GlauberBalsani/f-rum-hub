package com.balsani.forum.services;

import com.balsani.forum.domain.usuario.Usuario;
import com.balsani.forum.domain.usuario.UsuarioRequestDTO;

import com.balsani.forum.domain.usuario.UsuarioResponseDTO;
import com.balsani.forum.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    public List<UsuarioResponseDTO> getAll() {
        return usuarioRepository.
                findAll()
                .stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getEmail()

                ))
                .collect(Collectors.toList());
    }


}
