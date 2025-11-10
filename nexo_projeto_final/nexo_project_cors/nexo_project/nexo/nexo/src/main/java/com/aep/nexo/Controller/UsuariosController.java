package com.aep.nexo.Controller;

import com.aep.nexo.model.UsuariosModel;
import com.aep.nexo.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    // Criar novo usuário
    @PostMapping
    public ResponseEntity<UsuariosModel> criar(@RequestBody UsuariosModel usuario) {
        UsuariosModel novo = usuariosService.criarUsuario(usuario);
        return ResponseEntity.ok(novo);
    }

    // Login (autenticação)
    @PostMapping("/login")
    public ResponseEntity<UsuariosModel> autenticar(@RequestBody UsuariosModel credenciais) {
        Optional<UsuariosModel> usuario = usuariosService.buscarPorEmailESenha(
                credenciais.getEmail(), credenciais.getSenha()
        );

        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    // Deletar usuário autenticado
    @DeleteMapping
    public ResponseEntity<String> deletar(@RequestBody UsuariosModel credenciais) {
        boolean deletado = usuariosService.deletarPorEmailESenha(
                credenciais.getEmail(), credenciais.getSenha()
        );

        if (deletado) {
            return ResponseEntity.ok("Usuário deletado com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Usuário não encontrado ou credenciais inválidas.");
        }
    }

    // Atualizar informações do usuário autenticado
    @PutMapping
    public ResponseEntity<UsuariosModel> atualizar(
            @RequestParam String email,
            @RequestParam String senha,
            @RequestBody UsuariosModel novosDados
    ) {
        Optional<UsuariosModel> atualizado = usuariosService.atualizarUsuario(email, senha, novosDados);
        return atualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }
}
