package service;

import java.util.List;
import java.util.Scanner;

import models.Produto;
import utils.GerenciadorDeProdutos;

public class ProdutoMenu {

Scanner sc = new Scanner(System.in);
	
	// Gerenciador
	GerenciadorDeProdutos gp = new GerenciadorDeProdutos();
	
	// Construtor vazio
	public ProdutoMenu() {
		gp.verificarECria("produtos.txt");
	}
	
	public void criar() {
		System.out.println("Digite o nome do Produto: ");
		String nome = sc.next();
		System.out.println("Digite o preço do Produto: ");
		double preco = sc.nextDouble();
		System.out.println("Digite a quantide de Produtos: ");
		int quantidade = sc.nextInt();
		
		int id = getNextId();

		Produto u = new Produto(id, nome, preco, quantidade);
		gp.adicionarProduto(u);
	}

	public void editar() {
		System.out.println("Digite o ID do usuario: ");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome do Produto: ");
		String nome = sc.next();
		System.out.println("Digite a novo preço do Produto: ");
		double preco = sc.nextDouble();
		System.out.println("Digite a quantidade de Produtos: ");
		int quantidade = sc.nextInt();
		gp.editarProduto(id, nome, preco, quantidade);
	}

	public void deletar() {
		System.out.println("Digite o ID do produto a ser deletado: ");
		int id = sc.nextInt();
		gp.deletarProduto(id);	}

	public void listar() {
		gp.listarProdutos();
	}
	
	public void visualizar() {
		System.out.println("Digite o ID do produto a ser visualizado: ");
		int id = sc.nextInt();
		gp.detalharProduto(id);
	}
	
	

	public void sair() {
		System.err.println("Você saiu...");
		System.exit(0);
	}
	
	private int getNextId() {
		List<Produto> produtos = gp.lerProdutos();
		int maxId = 0;
		
		for(Produto produto : produtos) {
			int id = (int) produto.getId();
			if(id > maxId) {
				maxId = id;
			}
		}
		return maxId + 1;
	}
	
}
