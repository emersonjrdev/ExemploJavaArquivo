package models;

import java.util.Scanner;

import service.ProdutoMenu;

public class Produto {
	// id => 213232132 int
	// id => 2.4354343.323232.34343. long
	private long id;
	private String nome;
	private double preco;
	private int quantidades;
	
	
	public Produto(long id, String nome, double preco, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidades = quantidade;
	}

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidades() {
		return quantidades;
	}
	public void setQuantidades(int quantidades) {
		this.quantidades = quantidades;
	}
	
	@Override
	public String toString() {
	 return id + ";" + nome + ";" + preco + ";" + quantidades;
	}
	
	public void ProdMenu () {
			Scanner sc = new Scanner(System.in);
			ProdutoMenu pm = new ProdutoMenu();
			int opcao = 0;
			do {
				System.out.println("1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n5 - Visualizar ID \n9 - Sair \n");
				opcao = sc.nextInt();
				
				switch (opcao) {
				case 1 :{
					pm.criar();
					continue;
				}
				case 2:{
					pm.editar();
					continue;
				}
				case 3:{
					pm.deletar();
					continue;
				}
				case 4:{
					pm.listar();
					continue;
				}
				case 5:{
					pm.visualizar();
					continue;
				}

				case 9:{
					pm.sair();		
				}
				default:
					System.err.println("Opcçao Invalida");
					continue;
				}
				
			} while (opcao != 9);
			sc.close();

		
	}
	
	
}