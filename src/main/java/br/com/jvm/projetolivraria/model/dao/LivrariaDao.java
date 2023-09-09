package br.com.jvm.projetolivraria.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.jvm.projetolivraria.model.entidades.Livro;

public class LivrariaDao {
	// Modulo de Conexão
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dblivraria?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "1234567";

	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}
	/*
	 * //Teste de conexão public void testeConexao() { try { Connection con =
	 * conectar(); System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */

	// CRUD CREATE
	public void inserirLivro(Livro livro) {
		String create = "insert into livros (titulo, genero, quantidadePaginas, isbn) values (?, ?, ?, ?)";
		try {
			// Abrir conexão com o banco
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis Livro
			pst.setString(1, livro.getTitulo());
			pst.setString(2, livro.getGenero());
			pst.setString(3, livro.getQuantidadePaginas());
			pst.setString(4, livro.getIsbn());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// CRUD READ
	public ArrayList<Livro> listarLivros() {
		// Criando um objeto para acessar a classe Livro
		ArrayList<Livro> livros = new ArrayList<>();
		String read = "select * from livros order by titulo";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laço abaixo será executado enquanto houver livros
			while (rs.next()) {
				// Variáveis de apoio que recebem os dados do banco
				Long id = rs.getLong(1);
				String titulo = rs.getString(2);
				String genero = rs.getString(3);
				String quantidadePaginas = rs.getString(4);
				String isbn = rs.getString(5);
				// populando o ArrayList
				livros.add(new Livro(id, titulo, genero, quantidadePaginas, isbn));
			}
			con.close();
			return livros;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	//CRUD UPDATE
	//Selecionar o livro
	public void selecionarLivro(Livro livro) {
		String read2 = "select * from livros where id = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setLong(1, livro.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next() ) {
				//Setar as variaveis Livro
				livro.setId(rs.getLong(1));
				livro.setTitulo(rs.getString(2));
				livro.setGenero(rs.getString(3));
				livro.setQuantidadePaginas(rs.getString(4));
				livro.setIsbn(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	//Editar o Livro
	public void alterarLivro(Livro livro) {
		String create = "update livros set titulo=?, genero=?, quantidadePaginas=?, isbn=? where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
		
			pst.setString(1, livro.getTitulo());
			pst.setString(2, livro.getGenero());
			pst.setString(3, livro.getQuantidadePaginas());
			pst.setString(4, livro.getIsbn());
			pst.setLong(5, livro.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//CRUD DELETE
	public void deletarLivro(Livro livro) {
		String delete = "delete from livros where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setLong(1, livro.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	

}
