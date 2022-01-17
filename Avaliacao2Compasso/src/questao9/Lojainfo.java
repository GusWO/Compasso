package questao9;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class Lojainfo {

	public static void main(String[] args) throws ParseException, SQLException {
		
		Conexao conexao = new Conexao();
		Connection connection = conexao.iniciaConexao();
		ControleDeAcoes controle = new ControleDeAcoes();
		Scanner scan = new Scanner(System.in);
		int op = 0;
		while(op != 5) {
			mostraOpcao();
			op = scan.nextInt();
			switch (op) {
			case 1:
				controle.InsereDados();
				System.out.println("Digite outra opção:");
				break;
			case 2:
				controle.listar();
				break;
			case 3:
				controle.atualizar();
				break;
			case 4:
				controle.deletar();
				break;
			case 5:
				System.out.println("Saindo do programa");
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}
	
	public static void mostraOpcao() {
		System.out.println("Escolha suas opções");
		System.out.println("-----Loja Info-----");
		System.out.println("1 - Inserir um produto");
		System.out.println("2 - Listar um produto");
		System.out.println("3 - Atualizar um produto");
		System.out.println("4 - Deletar um produto");
		System.out.println("5 - Sair do programa");
	}
	
	

}

