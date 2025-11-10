package com.aep.nexo.Controller;

import com.aep.nexo.model.EmpreendedoresModel;
import com.aep.nexo.service.EmpreendedoresService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/empreendedores")
public class EmpreendedoresController {

    @Autowired
    private EmpreendedoresService empreendedoresService;

    // Criar novo empreendedor
    @PostMapping
    public ResponseEntity<EmpreendedoresModel> criar(@RequestBody EmpreendedoresModel empreendedor) {
        EmpreendedoresModel novo = empreendedoresService.criarEmpreendedor(empreendedor);
        return ResponseEntity.ok(novo);
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<EmpreendedoresModel>> listarTodos() {
        return ResponseEntity.ok(empreendedoresService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<EmpreendedoresModel> buscarPorId(@PathVariable Long id) {
        Optional<EmpreendedoresModel> encontrado = empreendedoresService.buscarPorId(id);
        return encontrado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<EmpreendedoresModel> atualizar(
            @PathVariable Long id,
            @RequestBody EmpreendedoresModel novosDados
    ) {
        Optional<EmpreendedoresModel> atualizado = empreendedoresService.atualizarEmpreendedor(id, novosDados);
        return atualizado.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        boolean deletado = empreendedoresService.deletarEmpreendedor(id);
        if (deletado) {
            return ResponseEntity.ok("Empreendedor deletado com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Empreendedor não encontrado.");
        }
    }
}
