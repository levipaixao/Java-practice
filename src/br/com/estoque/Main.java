package br.com.estoque;

import br.com.estoque.model.Produto;
import br.com.estoque.service.EstoqueService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        EstoqueService estoque = new EstoqueService();

        System.out.println("=== Sistema de Estoque ===");

        System.out.print("Quantos produtos deseja cadastrar? ");
        int quantidadeProdutos = input.nextInt();
        input.nextLine(); // limpar buffer

        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.println("\nProduto " + (i + 1));

            System.out.print("Nome: ");
            String nome = input.nextLine();

            System.out.print("Preço: ");
            double preco = input.nextDouble();

            System.out.print("Quantidade: ");
            int quantidade = input.nextInt();
            input.nextLine(); // limpar buffer

            Produto produto = new Produto(nome, preco, quantidade);
            estoque.adicionar(produto);
        }

        System.out.println("Vai querer levar algum produto para o estoque? S/N");
        char sn = input.next().charAt(0);
        if (sn == 's'){
            System.out.println("Quantos produtos vão querer levar? ");
            int levar = input.nextInt();
            for (int i = 0; i < levar; i++) {
                System.out.println("Quais produtos? ");
                input.nextLine();
                String produto = input.nextLine();
                // filtrando o produto para ver se existe na lista
                 estoque.buscar(produto);
                // caso nao estiver o produto é nulo
                if (produto == null){
                    System.out.println("Produto inexistente! ");
                } else {
                    // retira o produto da lista
                    System.out.println("Produto retirado: " + produto);
                    estoque.remover(produto);
                }

            }
            // para se nao quiser retirar o produto
        }else if(sn == 'n') {
            System.out.println("Nenhum produto retirado");
        }

        System.out.println("\n=== Produtos no estoque ===");
        estoque.listar().forEach(System.out::println);

        input.close();
    }
}