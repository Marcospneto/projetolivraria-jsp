package br.com.jvm.projetolivraria.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.jvm.projetolivraria.connection.ConnectionBanco;
import br.com.jvm.projetolivraria.model.entidades.Comentario;
import br.com.jvm.projetolivraria.model.entidades.Livro;
import br.com.jvm.projetolivraria.model.entidades.Usuario;

public class ComentarioDao {
	private static ConnectionBanco connectionBanco = new ConnectionBanco();
	private static LivrariaDao livrariaDao = new LivrariaDao();
	private static UsuarioDao usuarioDao = new UsuarioDao();

	// CRUD CREATE
	public void inserirComentario(Comentario comentario) {
		String create = "insert into comentario (usuario_login, livro_id, comentario, data_comentario) values (?, ?, ?, ?)";
		try {
			// Abrindo conexão com o banco
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis Comentario

			String usuarioLogin = comentario.getUsuario().getLogin();
			pst.setString(1, usuarioLogin);
			pst.setLong(2, comentario.getLivro().getId());
			pst.setString(3, comentario.getComentario());
			java.sql.Date dataSql = new java.sql.Date(comentario.getData_comentario().getTime());
			pst.setDate(4, dataSql);

			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Comentario> listarComentario(Long livroId) {
		ArrayList<Comentario> comentarios = new ArrayList<>();
		String read = "select * from comentario order by data_comentario";
		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Long id = rs.getLong(1);
				Long usuarioId = rs.getLong(2);
				String comenta = rs.getString(3);
				Date dataComentario = rs.getDate(4);

				Usuario usuario = usuarioDao.buscarUsuarioPorId(usuarioId);
				//Livro livro = livrariaDao.buscarLivroPorL(livroId);

				Comentario comentario = new Comentario(id, usuario, null, comenta, dataComentario);
				comentarios.add(comentario);
			}
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentarios;
	}
	

	public void deletarComentario(Comentario comentario) {
		String delete = "delete from comentario where id=?";
		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setLong(1, comentario.getId());
			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<Comentario> listarComentariosDoLivro(Long livroId) {
	    List<Comentario> comentarios = new ArrayList<>();
	    String read = "SELECT * FROM comentario WHERE livro_id = ? ORDER BY data_comentario";

	    try (Connection con = connectionBanco.getConnection();
	         PreparedStatement pst = con.prepareStatement(read)) {

	    	pst.setLong(1, livroId);
	        try (ResultSet rs = pst.executeQuery()) {
	            while (rs.next()) {
	                Long comentarioId = rs.getLong("id");
	                String usuarioLogin = rs.getString("usuario_login");
	                String comentarioTexto = rs.getString("comentario");
	                Date dataComentario = rs.getDate("data_comentario");
	                
	                Usuario usuario = usuarioDao.buscarUsuarioPorLogin(usuarioLogin);
	                
	                Livro livroRelacionado = new Livro();
	                livroRelacionado.setId(livroId);
	               
	                Comentario comentario = new Comentario(comentarioId, usuario, livroRelacionado, 
	                		comentarioTexto, dataComentario);
	                comentarios.add(comentario);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return comentarios;
	}




}
