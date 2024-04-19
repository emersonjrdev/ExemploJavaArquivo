package models;

import java.util.Scanner;

import service.HandleMenu;

public class Usuario {

	// Identificador
	private int id;

	private String nome;
	private String senha;

	public Usuario(int id, String nome, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// Sobrescrever metodo
	@Override
	public String toString() {
		return id + ";" + nome + ";" + senha;
	}
	
	public void UserMenu() {
		Scanner sc = new Scanner(System.in);
		HandleMenu hm = new HandleMenu();
		int opcao = 0;
		
		do {
			System.out.println("1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n5 - Visualizar ID \n6 - Login \n7 - Trocar senha \n9 - Sair \n");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1 :{
				hm.criar();
				continue;
			}
			case 2:{
				hm.editar();
				continue;
			}
			case 3:{
				hm.deletar();
				continue;
			}
			case 4:{
				hm.listar();
				continue;
			}
			case 5:{
				hm.visualizar();
				continue;
			}
			case 6:{
				hm.login();
				continue;
			}
			case 7:{
				hm.trocarSenha();
				continue;
			}
			case 9:{
				hm.sair();		
			}
			default:
				System.err.println("Opcçao Invalida");
				continue;
			}
			
		} while (opcao != 9);
		sc.close();

	}
	}


