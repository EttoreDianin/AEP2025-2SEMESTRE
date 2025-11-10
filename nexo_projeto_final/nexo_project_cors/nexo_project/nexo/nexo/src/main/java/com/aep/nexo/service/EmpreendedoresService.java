package com.aep.nexo.service;

import com.aep.nexo.model.EmpreendedoresModel;
import com.aep.nexo.repository.EmpreendedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpreendedoresService {

    @Autowired
    private EmpreendedoresRepository empreendedoresRepository;

    // Criar novo empreendedor
    public EmpreendedoresModel criarEmpreendedor(EmpreendedoresModel empreendedor) {
        return empreendedoresRepository.save(empreendedor);
    }

    // Buscar todos os empreendedores
    public List<EmpreendedoresModel> listarTodos() {
        return empreendedoresRepository.findAll();
    }

    // Buscar por ID
    public Optional<EmpreendedoresModel> buscarPorId(Long id) {
        return empreendedoresRepository.findById(id);
    }

    // Atualizar empreendedor
    public Optional<EmpreendedoresModel> atualizarEmpreendedor(Long id, EmpreendedoresModel novosDados) {
        Optional<EmpreendedoresModel> existenteOpt = empreendedoresRepository.findById(id);

        if (existenteOpt.isPresent()) {
            EmpreendedoresModel existente = existenteOpt.get();

            if (novosDados.getTipo() != null) existente.setTipo(novosDados.getTipo());
            if (novosDados.getNomeEmpreendedor() != null) existente.setNomeEmpreendedor(novosDados.getNomeEmpreendedor());
            if (novosDados.getItem() != null) existente.setItem(novosDados.getItem());
            if (novosDados.getDescricao() != null) existente.setDescricao(novosDados.getDescricao());
            if (novosDados.getCategoria() != null) existente.setCategoria(novosDados.getCategoria());
            if (novosDados.getPreco() != null) existente.setPreco(novosDados.getPreco());
            if (novosDados.getCidade() != null) existente.setCidade(novosDados.getCidade());
            if (novosDados.getImagem() != null) existente.setImagem(novosDados.getImagem());

            empreendedoresRepository.save(existente);
            return Optional.of(existente);
        }

        return Optional.empty();
    }

    // Deletar empreendedor
    public boolean deletarEmpreendedor(Long id) {
        if (empreendedoresRepository.existsById(id)) {
            empreendedoresRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
