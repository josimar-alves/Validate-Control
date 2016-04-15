package com.example.jr.validatecontrol;

import java.util.List;

public class ProdutoManager {
    private List <Produto> produtos;

    public ProdutoManager(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void cadastrarProduto(Produto p) {
        produtos.add(p);
    }

    public void removerProduto(Produto p) {
        produtos.remove(p);
    }

    public void editarProduto(Produto p) {
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}