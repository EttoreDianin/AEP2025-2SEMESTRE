package com.aep.nexo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmpreendedoresModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String tipo;
    private String nomeEmpreendedor;
    private String item;
    private String descricao;
    private String categoria;
    private String preco;
    private String cidade;
    private String imagem;

//====================================================================================================================//

    public EmpreendedoresModel() { }

//====================================================================================================================//

    public String getTipo() {
        return tipo;
    }

    public String getNomeEmpreendedor() {
        return nomeEmpreendedor;
    }

    public String getItem() {
        return item;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPreco() {
        return preco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getImagem() {
        return imagem;
    }

//====================================================================================================================//

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNomeEmpreendedor(String nomeEmpreendedor) {
        this.nomeEmpreendedor = nomeEmpreendedor;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
