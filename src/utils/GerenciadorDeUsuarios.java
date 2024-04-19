package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

public class GerenciadorDeUsuarios {
	private static final String NOME_ARQUIVO = "usuarios.txt";

	// Verificar a Existência do nosso banco e criar caso não exista
	public void verificaECria(String nomeArquivo) {
		// file => arquivo
		File arquivo = new File(nomeArquivo);

		if (arquivo.exists()) {
			System.out.println("Banco Funcionando! ");
		} else {
			// tente criar, caso de erro, exibe o erro
			try {
				// Criar o novo arquivo
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso! ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
			}
		}
	}

	public void adicionarUsuario(Usuario usuario) {
		// Writer => Escrever
		// BuffereWriter, FileWriter
		// BufferedWriter, proporciona uma eficiente escrita
		// FileWriter, escreva dentro do arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(usuario.toString()); // 1;arthur;12345
			bw.newLine();
			System.out.println("Usuario adicionado com sucesso! ");
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
		}
	}
	
	public List<Usuario> lerUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		// Buffed, File, 	Reader
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha; // linha => 1;nome;senha
			// percorrer todas as linhas enquanto seja diferente de vazio
			while((linha = br.readLine())!= null) {
				String[] partes = linha.split(";"); // dividir em tres partes
				usuarios.add(new Usuario (Integer.parseInt(partes[0]), partes[1], partes[2]));
			}
			
		} catch (IOException e) {
			System.err.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());		
			
		}
		return usuarios;
	}
	
	public void deletarUsuario(int id) {
			List<Usuario> usuarios = lerUsuarios();
		
			if(usuarios.removeIf(usuario -> usuario.getId() == id)) {
				reescreverArquivo(usuarios);
				System.out.println("Usuario deletado com sucesso! ");
			}else {
				System.err.println("Usuario não encontrado");
			}
	}
	
	public void reescreverArquivo(List<Usuario> usuarios) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for(Usuario usuario : usuarios) {
				bw.write(usuario.toString());
				bw.newLine();
			}
		} catch (IOException e) {
				System.err.println("Ocorreu um erro ao reescrever o arquivo: " + e.getMessage());
		}
	}

	public void listarUsuarios() {
		List<Usuario> usuarios = lerUsuarios();
		// nenhum usuario
		if(usuarios.isEmpty()) {
			System.out.println("Nenhum usuario cadastrado");
		}else {
			System.out.println("Lista de usuarios");
			for(Usuario usuario : usuarios) {
				System.out.println("ID: " + usuario.getId() + ", Nome: " + "" + usuario.getNome() + ",Senha: " + usuario.getSenha());
			}
		}
	}
	
	public void editarUsuario(int id, String novoNome, String novaSenha) {
		List<Usuario> usuarios = lerUsuarios();
		boolean encontrado = false; 
		
		for (Usuario usuario : usuarios) {
			if(usuario.getId() == id) {
				usuario.setNome(novoNome);
				usuario.setSenha(novaSenha);
				encontrado = true;
				break;
			}
		}
		
		if (encontrado) {
			reescreverArquivo(usuarios);
			System.out.println("Usuario editado com sucesso");
		}else {
			System.err.println("Usuario não encontrado");
		}
		
	}
	
	public void visualizarUsuario(int id) {
	    List<Usuario> usuarios = lerUsuarios();
	    boolean usuarioEncontrado = false;

	    for (Usuario usuario : usuarios) {
	        if (usuario.getId() == id) {
	            System.out.println("ID: " + usuario.getId() + ", Nome: " + "" + usuario.getNome() + ",Senha: " + usuario.getSenha());
	            usuarioEncontrado = true;
	            break; 
	        }
	    }

	    if (!usuarioEncontrado) {
	        System.err.println("Usuario não encontrado");
	    }
	}

	public boolean verificarLoginExistente(String nome, String senha) {
	    List<Usuario> usuarios = lerUsuarios();
	    for (Usuario usuario : usuarios) {
	        if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
	            return true; 
	        }
	    }
	    return false; 
	}

	public boolean trocarSenha(int id, String senhaAtual, String novaSenha) {
		List<Usuario> usuarios = lerUsuarios();
		
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id && usuario.getSenha().equals(senhaAtual)) {
				usuario.setSenha(novaSenha);
				reescreverArquivo(usuarios);
				return true;
			}
		}
		
		return false;
	}
}
