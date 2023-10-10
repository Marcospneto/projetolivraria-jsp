package br.com.jvm.projetolivraria.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBanco {
	// Modulo de Conex�o
	// Par�metros de conex�o
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dblivraria?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "1234567";

	public Connection getConnection() {
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
	 * //Teste de conex�o public void testeConexao() { try { Connection con =
	 * conectar(); System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */
}
