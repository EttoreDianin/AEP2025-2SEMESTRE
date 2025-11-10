package com.aep.nexo.service;

import com.aep.nexo.model.UsuariosModel;
import com.aep.nexo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Criar novo usuário
    public UsuariosModel criarUsuario(UsuariosModel usuario) {
        return usuariosRepository.save(usuario);
    }

    // Buscar usuário autenticado
    public Optional<UsuariosModel> buscarPorEmailESenha(String email, String senha) {
        return usuariosRepository.findByEmailAndSenha(email, senha);
    }

    // Deletar usuário autenticado
    public boolean deletarPorEmailESenha(String email, String senha) {
        Optional<UsuariosModel> usuario = usuariosRepository.findByEmailAndSenha(email, senha);
        if (usuario.isPresent()) {
            usuariosRepository.delete(usuario.get());
            return true;
        }
        return false;
    }

    // Atualizar informações de um usuário autenticado
    public Optional<UsuariosModel> atualizarUsuario(String email, String senha, UsuariosModel novosDados) {
        Optional<UsuariosModel> usuarioOpt = usuariosRepository.findByEmailAndSenha(email, senha);

        if (usuarioOpt.isPresent()) {
            UsuariosModel usuario = usuarioOpt.get();

            if (novosDados.getNome() != null) usuario.setNome(novosDados.getNome());
            if (novosDados.getEmail() != null) usuario.setEmail(novosDados.getEmail());
            if (novosDados.getSenha() != null) usuario.setSenha(novosDados.getSenha());

            usuariosRepository.save(usuario);
            return Optional.of(usuario);
        }

        return Optional.empty();
    }
}
