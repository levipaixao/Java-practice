package br.com.estoque.service;

import br.com.estoque.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class EstoqueService {

    private List<Produto> produtos = new ArrayList<>();

    public void adicionar (Produto produto){
        produtos.add(produto);
    }
    public Produto buscar (String nome) {
        return produtos.stream().filter(p-> p.getProduto().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }
    public void remover(String produto){
        produtos.remove(produto);
    }
    public List<Produto> listar(){
        return produtos;
    }
}
