package com.balsani.forum.services;

import com.balsani.forum.domain.usuario.Usuario;
import com.balsani.forum.domain.usuario.UsuarioRequestDTO;

import com.balsani.forum.domain.usuario.UsuarioRequestUpdateDTO;
import com.balsani.forum.domain.usuario.UsuarioResponseDTO;
import com.balsani.forum.infra.NotFoundException;
import com.balsani.forum.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public UsuarioResponseDTO getById(Long id) {
        return usuarioRepository.findById(id).map(UsuarioResponseDTO::new)
                .orElseThrow(()-> new NotFoundException("Usuário não encontrado com esse id"));

    }

    @Transactional
    public Optional<UsuarioRequestDTO> updateById(Long id, UsuarioRequestUpdateDTO usuarioRequestUpdateDTO) {
        return usuarioRepository.findById(id).map( usuario -> {
            usuario.setNome(usuarioRequestUpdateDTO.nome());
            usuario.setEmail(usuarioRequestUpdateDTO.email());

            return UsuarioRequestDTO.toModel(usuario);
                });


    }

    @Transactional
    public void delete(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
        usuario.excluir();
        usuarioRepository.save(usuario);
    }




}
