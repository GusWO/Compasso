package questao9;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleDeAcoes {

	Conexao conexao = new Conexao();
	Connection connection = conexao.iniciaConexao();
	Scanner scan = new Scanner(System.in);
	Produto produto = new Produto();
	String nome;
	String descricao;
	float desconto;
	Integer id;
	long dataInicio;

	public void InsereDados() throws ParseException {
		try {
			String InsereSql = "INSERT INTO PRODUTO (nome, descricao, desconto, data_inicio) VALUES (?, ?, ?, ?)";
			try (PreparedStatement pst = connection.prepareStatement(InsereSql, Statement.RETURN_GENERATED_KEYS)) {
				System.out.println("Digite o nome do produto: ");
				nome = scan.nextLine();
				System.out.println("Digite a descrição do produto: ");
				descricao = scan.nextLine();
				System.out.println("Digite o desconto do produto: ");
				desconto = scan.nextFloat();
				System.out.println("Digite a data de início do produto:");
				dataInicio = scan.nextLong();
				pst.setString(1, nome);
				pst.setString(2, descricao);
				pst.setFloat(3, desconto);
				pst.setDate(4, new java.sql.Date(dataInicio));

				pst.execute();

				try (ResultSet rst = pst.getGeneratedKeys()) {
					while (rst.next()) {
						produto.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizar() throws SQLException, ParseException {
		String nome;
		String descricao;
		Integer id = null;
		try (PreparedStatement pst = connection
				.prepareStatement("UPDATE PRODUTO SET NOME = ?, DESCRICAO = ? WHERE ID = ?")) {
			System.out.println("Digite o ID do produto: ");
			id = scan.nextInt();
			System.out.println("Digite o novo nome do produto: ");
			nome = scan.next();
			System.out.println("Digite a nova descrição do produto: ");
			descricao = scan.next();
			
			pst.setString(1, nome);
			pst.setString(2, descricao);
			pst.setInt(3, id);

			pst.execute();
			
			try(ResultSet rst = pst.getResultSet()){
				if(rst.wasNull()) {
					System.out.println("Não existem produtos cadastrados, por favor, cadastre-os");
					InsereDados();
				}
			}

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
		
	}

	public void deletar() throws SQLException, ParseException {
		Integer id;
		try (PreparedStatement pst = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")) {
			System.out.println("Digite o id do produto que você deseja excluir.");
			id = scan.nextInt();
			pst.setInt(1, id);
			pst.execute();
			
			if(id == null) {
				System.out.println("Não existem produtos neste banco de dados, por favor adicione.");
				InsereDados();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Produto> listar() throws SQLException, ParseException {
		String nome;
		List<Produto> produtos = new ArrayList<Produto>();
		try (PreparedStatement pst = connection.prepareStatement("SELECT * FROM PRODUTO WHERE NOME = ?")) {
			System.out.println("Digite a palavra chave do produto que você deseja pesquisar: ");
			nome = scan.nextLine();
			pst.setString(1, nome);
			

			pst.execute();
			try (ResultSet rst = pst.getResultSet()) {
				while (rst.next()) {
					Integer id = rst.getInt("ID");
					nome = rst.getString("NOME");
					String descricao = rst.getString("DESCRICAO");
					float desconto = rst.getFloat("DESCONTO");
					Date data = rst.getDate("DATA_INICIO");
					System.out.println("|Id: " + id + " | Nome: " + nome + " | Descrição: " + descricao
							+ " | Desconto: " + desconto + " | Data: " + data);
					if(rst.wasNull()) {
						
						System.out.println("Não existem produtos neste banco de dados, por favor adicione.");
						InsereDados();
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return produtos;
	}
}
