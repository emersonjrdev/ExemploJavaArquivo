package service;

import java.util.List;
import java.util.Scanner;

import models.Usuario;
import utils.GerenciadorDeUsuarios;

public class HandleMenu {

	Scanner sc = new Scanner(System.in);
	
	// Gerenciador
	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();
	
	// Construtor vazio
	public HandleMenu() {
		gs.verificaECria("usuarios.txt");
	}
	
	public void criar() {
		System.out.println("Digite seu nome: ");
		String nome = sc.next();
		System.out.println("Digite sua senha: ");
		String senha = sc.next();
		
		int id = getNextId();

		Usuario u = new Usuario(id, nome, senha);
		gs.adicionarUsuario(u);
	}

	public void editar() {
		System.out.println("Digite o ID do usuario: ");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome: ");
		String nome = sc.next();
		System.out.println("Digite a nova senha: ");
		String senha = sc.next();
		gs.editarUsuario(id, nome, senha);
	}

	public void deletar() {
		System.out.println("Digite o ID do usuario a ser deletado: ");
		int id = sc.nextInt();
		gs.deletarUsuario(id);	}

	public void listar() {
		gs.listarUsuarios();
	}
	
	public void visualizar() {
		System.out.println("Digite o ID do usuario a ser visualizado: ");
		int id = sc.nextInt();
		gs.visualizarUsuario(id);
	}
	
	public void login() {
	    System.out.println("Digite seu nome de usuário: ");
	    String nome = sc.next();
	    System.out.println("Digite sua senha: ");
	    String senha = sc.next();

	    if (gs.verificarLoginExistente(nome, senha)) {
	        System.out.println("Login realizado com sucesso!");
	    } else {
	        System.err.println("Usuário ou senha incorretos. Por favor, tente novamente.");
	    }
	}

	public void sair() {
		System.err.println("Você saiu...");
		System.exit(0);
	}
	
	private int getNextId() {
		List<Usuario> usuarios = gs.lerUsuarios();
		int maxId = 0;
		
		for(Usuario usuario : usuarios) {
			int id = usuario.getId();
			if(id > maxId) {
				maxId = id;
			}
		}
		return maxId + 1;
	}
}
