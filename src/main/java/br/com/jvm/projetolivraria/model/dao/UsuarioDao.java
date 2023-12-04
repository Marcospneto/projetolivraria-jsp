package br.com.jvm.projetolivraria.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.jvm.projetolivraria.connection.ConnectionBanco;
import br.com.jvm.projetolivraria.model.entidades.Usuario;

public class UsuarioDao {
	private static ConnectionBanco connectionBanco = new ConnectionBanco();

	public void inserirUsuario(Usuario usuario) {
		String create = "insert into usuario (login, senha, perfil) values (?, ?, ?)";
		try {
			// Abrir conexão com o banco
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parametros (?) pelo conteudo das variaveis Livro
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, usuario.getPerfil());

			pst.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Usuario> listarUsuario() {
		// Criando um objeto para acessar a classe Usuario
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String read = "select * from usuario order by perfil";
		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laço abaixo será executado enquanto houver usuarios
			while (rs.next()) {
				Long id = rs.getLong(1);
				String login = rs.getString(2);
				String senha = rs.getString(3);
				String perfil = rs.getString(4);
				// Polulando o ArrayList
				usuarios.add(new Usuario(id, login, senha, perfil));
			}
			con.close();
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deletarUsuario(Usuario usuario) {
		String delete = "delete from usuario where id=?";
		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setLong(1, usuario.getId());
			pst.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// CRUD UPDATE
	// Selecionar o usuario
	public void selecionarUsuario(Usuario usuario) {
		String read2 = "select * from usuario where id = ?";
		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setLong(1, usuario.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Setar as variaveis Usuario
				usuario.setId(rs.getLong(1));
				usuario.setLogin(rs.getString(2));
				usuario.setPerfil(rs.getString(4));
			}
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);;
		}
	}

	public void alterarUsuario(Usuario usuario) {
		String update = "update usuario set perfil=? where id=?";
		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(update);

			pst.setString(1, usuario.getPerfil());
			pst.setLong(2, usuario.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Usuario buscarUsuarioPorId(Long usuarioId) {
		String query = "SELECT * FROM usuario WHERE id = ?";
		Usuario usuario = null;

		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(1, usuarioId);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Long id = rs.getLong("id");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				String perfil = rs.getString("perfil");

				usuario = new Usuario(id, login, senha, perfil);
			}
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return usuario;
	}

	public Usuario buscarUsuarioPorLogin(String usuarioLogin) {
	    String query = "SELECT * FROM usuario WHERE login = ?";
	    Usuario usuario = null;

	    try (Connection con = connectionBanco.getConnection();
	         PreparedStatement pst = con.prepareStatement(query)) {

	        pst.setString(1, usuarioLogin);
	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                Long id = rs.getLong("id");
	                String login = rs.getString("login");
	                String senha = rs.getString("senha");
	                String perfil = rs.getString("perfil");

	                usuario = new Usuario(id, login, senha, perfil);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return usuario;
	}


	public Usuario autenticarUsuario(Usuario usuario) {
		Usuario usoRetorno = null;
		String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, usuario.getLogin());
			pst.setString(2, usuario.getSenha());
			// verificar se preciso do perfil na autenticação
			// pst.setString(3,usuario.getPerfil());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				// Usuário encontrado no banco de dados, crie um objeto de usuário
				usoRetorno = new Usuario();
				usoRetorno.setId(rs.getLong("id"));
				usoRetorno.setLogin(rs.getString("login"));
				usoRetorno.setSenha(rs.getString("senha"));
				usoRetorno.setPerfil(rs.getString("perfil"));
			}

			// Feche as conexões e recursos (PreparedStatement, ResultSet, etc.)
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usoRetorno;
	}

	public boolean loginExiste(String login) {
		String sql = "SELECT COUNT(*) FROM usuario WHERE login = ?";

		try {
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, login);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);
				return count > 0; // Se count for maior que 0, o login já existe
			}
			pst.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // Em caso de erro ou se o login não existir
	}

}
