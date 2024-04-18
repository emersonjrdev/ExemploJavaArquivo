package sistema;

import java.util.Scanner;

import models.Produto;
import models.Usuario;
import service.HandleMenu;
import service.ProdutoMenu;

public class Sistema {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HandleMenu hm = new HandleMenu();
		int opcao = 0;
		ProdutoMenu pm = new ProdutoMenu();
		Usuario user = new Usuario();
		Produto prod = new Produto();

		do {
			hm.firstMenu();
			opcao = sc.nextInt();
			switch (opcao) {
			case 1: {
				user.UserMenu();
				continue;
			} case 2: {
				prod.ProdMenu();
				continue;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		} while (opcao != 9);

 
}

}
