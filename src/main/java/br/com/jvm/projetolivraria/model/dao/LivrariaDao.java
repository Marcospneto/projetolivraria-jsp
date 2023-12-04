package br.com.jvm.projetolivraria.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.jvm.projetolivraria.connection.ConnectionBanco;
import br.com.jvm.projetolivraria.model.entidades.Comentario;
import br.com.jvm.projetolivraria.model.entidades.Livro;

public class LivrariaDao {
	private static ConnectionBanco connectionBanco = new ConnectionBanco();
	UsuarioDao usuarioDao = new UsuarioDao();
	ComentarioDao comentarioDao = new ComentarioDao();
	// CRUD CREATE
	public void inserirLivro(Livro livro) {
		String create = "insert into livros (titulo, genero, quantidadePaginas, isbn, sinopse, autor)"
				+ " values (?, ?, ?, ?, ?, ?)";
		try {
			// Abrir conexão com o banco
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis Livro
			pst.setString(1, livro.getTitulo());
			pst.setString(2, livro.getGenero());
			pst.setString(3, livro.getQuantidadePaginas());
			pst.setString(4, livro.getIsbn());
			pst.setString(5, livro.getSinopse());
			pst.setString(6, livro.getAutor());
			
			pst.executeUpdate();
			
			//Se tiver arquivo de imagem, executa essa segunda query
			/*if(livro.getImagem() != null && !livro.getImagem().isEmpty()) {
                create = "update livros set imagem =?, extensao_img = ? where titulo = ?";

                pst = con.prepareStatement(create);

                pst.setString(1, livro.getImagem());
                pst.setString(2, livro.getExtensaoImg());
                pst.setString(3, livro.getTitulo());

                pst.executeUpdate();

              }*/
			
			pst.close();
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
	        Connection con = connectionBanco.getConnection();
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
	            String sinopse = rs.getString(6);
	            String autor = rs.getString(7);

	           
	          //Obter a lista de comentários para o livro usando o ComentarioDao
	         // List<Comentario> comentarios = comentarioDao.listarComentariosDoLivro(id);

	            // Criar uma instância de Livro
	            Livro livro = new Livro(id, titulo, genero, quantidadePaginas, isbn, sinopse, autor, null, null, null, null);

	           

	            // Adicionar o livro à lista
	            livros.add(livro);
	        }
	        pst.close();
	        con.close();
	        return livros;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}

	
	
	

	
	// Selecionar o livro
	public void selecionarLivro(Livro livro) {
		String read2 = "select * from livros where id = ?";
		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setLong(1, livro.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Setar as variaveis Livro
				livro.setId(rs.getLong(1));
				livro.setTitulo(rs.getString(2));
				livro.setGenero(rs.getString(3));
				livro.setQuantidadePaginas(rs.getString(4));
				livro.setIsbn(rs.getString(5));
				livro.setSinopse(rs.getString(6));
				livro.setAutor(rs.getString(7));
				livro.setImagem(rs.getString(8));
			//	List<Comentario> comentarios = comentarioDao.listarComentariosDoLivro(livro.getId());
			//	livro.setComentarios(comentarios);
		
			
			}
			pst.close();
			con.close();
		} catch (Exception e) {
	        System.out.println(e);
	    }
		
	}

	// Editar o Livro
	public void alterarLivro(Livro livro) {
		String create = "update livros set titulo=?, genero=?, quantidadePaginas=?, isbn=?, sinopse=?, autor=? where id=?";
		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, livro.getTitulo());
			pst.setString(2, livro.getGenero());
			pst.setString(3, livro.getQuantidadePaginas());
			pst.setString(4, livro.getIsbn());
			pst.setString(5, livro.getSinopse());
			pst.setString(6, livro.getAutor());
			pst.setLong(7, livro.getId());

			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
	        System.out.println(e);
	    }
	}

	

	// CRUD DELETE
	public void deletarLivro(Livro livro) {
		String delete = "delete from livros where id=?";
		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setLong(1, livro.getId());
			pst.executeUpdate();
			pst.close();
			con.close();
		}catch (Exception e) {
	        System.out.println(e);
	    }
	}

	

	public Livro procurarLivroPorId(String livroTitulo) {
		String query = "SELECT * FROM livros WHERE titulo = ?";
		Livro livro = null;

		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, livroTitulo);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Long id = rs.getLong("id");
				String titulo = rs.getString("titulo");
				String genero = rs.getString("genero");
				String quantidadePaginas = rs.getString("quantidadePaginas");
				String isbn = rs.getString("isbn");
				String sinopse = rs.getString("sinopse");
				String autor = rs.getString("autor");
				

	 		List<Comentario> comentarios = comentarioDao.listarComentariosDoLivro(id);

				livro = new Livro(id, titulo, genero, quantidadePaginas, isbn, sinopse, autor, null, null, null, null);
			}
			pst.close();
			con.close();
		} catch (Exception e) {
	        System.out.println(e);
	    }

		return livro;
	}
	
	
	
	
	// LivrariaDao.java
	public Livro procurarLivroPorTitulo(String livroTitulo) {
		String query = "SELECT * FROM livros WHERE titulo = ?";
		Livro livro = null;

		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, livroTitulo);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Long id = rs.getLong("id");
				String titulo = rs.getString("titulo");
				String genero = rs.getString("genero");
				String quantidadePaginas = rs.getString("quantidadePaginas");
				String isbn = rs.getString("isbn");
				String sinopse = rs.getString("sinopse");
				String autor = rs.getString("autor");
				

	 		List<Comentario> comentarios = comentarioDao.listarComentariosDoLivro(id);

				livro = new Livro(id, titulo, genero, quantidadePaginas, isbn, sinopse, autor, null, null, null, null);
			}
			pst.close();
			con.close();
		} catch (Exception e) {
	        System.out.println(e);
	    }

		return livro;
	}
}

