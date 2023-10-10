package br.com.jvm.projetolivraria.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.jvm.projetolivraria.connection.ConnectionBanco;
import br.com.jvm.projetolivraria.model.entidades.Usuario;

public class UsuarioDao {
	private static ConnectionBanco connectionBanco = new ConnectionBanco();
	
		
		public void inserirUsuario(Usuario usuario) {
			String create = "insert into usuario (login, senha) values (?, ?)";
			try {
				// Abrir conexão com o banco
				Connection con = connectionBanco.getConnection();
				PreparedStatement pst = con.prepareStatement(create);
				// substituir os parametros (?) pelo conteudo das variaveis Livro
				pst.setString(1, usuario.getLogin());
				pst.setString(2, usuario.getSenha());
				
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public Usuario autenticarUsuario(Usuario usuario) {
		    Usuario usoRetorno = null;
		    String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
		    try {
		    	Connection con = connectionBanco.getConnection();
		        PreparedStatement pst = con.prepareStatement(sql);
		        pst.setString(1, usuario.getLogin());
		        pst.setString(2, usuario.getSenha());
		        ResultSet rs = pst.executeQuery();
		        
		        if (rs.next()) {
		            // Usuário encontrado no banco de dados, crie um objeto de usuário
		            usoRetorno = new Usuario();
		            usoRetorno.setId(rs.getLong("id"));
		            usoRetorno.setLogin(rs.getString("login"));
		            usoRetorno.setSenha(rs.getString("senha"));
		        }
		        
		        // Feche as conexões e recursos (PreparedStatement, ResultSet, etc.)
		        rs.close();
		        pst.close();
		        con.close();
		    } catch (Exception e) {
		        System.out.println(e);
		    }
		    return usoRetorno;
		}

		
		
		
		
}
