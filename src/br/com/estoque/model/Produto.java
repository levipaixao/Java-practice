package br.com.estoque.model;

public class Produto {


    // getters e setters
    private String produto;
    private Double preco;
    private Integer quantidade;

    public Produto() {
    }
    //controller
    public Produto(String produto, Double preco, Integer quantidade) {
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    //controller
    public Produto(String produto, Integer quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    public String toString(){
        return  produto;
    }
}
