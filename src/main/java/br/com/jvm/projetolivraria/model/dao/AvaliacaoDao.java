package br.com.jvm.projetolivraria.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.jvm.projetolivraria.connection.ConnectionBanco;
import br.com.jvm.projetolivraria.model.entidades.Avaliacao;
import br.com.jvm.projetolivraria.model.entidades.Livro;

public class AvaliacaoDao {

	private static ConnectionBanco connectionBanco = new ConnectionBanco();
	private static LivrariaDao livrariaDao = new LivrariaDao();

	// CRUD CREATE
	public void inserirAvaliacao(Avaliacao avaliacao) {
		String create = "insert into avaliacao (livro_id, nota) values (?, ?)";
		try {
			// Abrir conexão com o banco
			Connection con = connectionBanco.getConnection();
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir os parametros (?) pelos valores de avaliação

			pst.setLong(1, avaliacao.getLivro().getId()); // Id do livro selecionado
			pst.setInt(2, avaliacao.getNota());

			pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public List<Avaliacao> listarAvaliacaoDoLivro(Long livroId) {
		List<Avaliacao> avaliacoes = new ArrayList<>();
		String read = "SELECT * FROM avaliacao WHERE livro_id = ?";

		try (Connection con = connectionBanco.getConnection(); PreparedStatement pst = con.prepareStatement(read)) {

			pst.setLong(1, livroId);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					Long avaliacaoId = rs.getLong("id");
					int nota = rs.getInt("nota");

					Livro livroRelacionado = new Livro();
					livroRelacionado.setId(avaliacaoId);

					Avaliacao avaliacao = new Avaliacao(avaliacaoId, livroRelacionado, nota);
					avaliacoes.add(avaliacao);

				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return avaliacoes;

	}

}
