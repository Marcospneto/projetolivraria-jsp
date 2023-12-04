package br.com.jvm.projetolivraria.bean;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jvm.projetolivraria.model.dao.AvaliacaoDao;
import br.com.jvm.projetolivraria.model.entidades.Avaliacao;
import br.com.jvm.projetolivraria.model.entidades.Livro;

public class AvaliacaoBean {
	AvaliacaoDao avaliacaoDao = new AvaliacaoDao();
	Avaliacao avaliacao = new Avaliacao();
	Livro livro = new Livro();

	public void novaAvaliacao(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // Setar as variáveis Avaliacao
	    String livroId = request.getParameter("livroId");

	    if (livroId != null && !livroId.isEmpty()) {
	        livro.setId(Long.parseLong(livroId));
	        avaliacao.setLivro(livro);

	        String notaStr = request.getParameter("nota");

	        System.out.println("Valor da notaStr: " + notaStr);

	        if (notaStr != null && !notaStr.isEmpty()) {
	            try {
	                int nota = Integer.parseInt(notaStr);
	                avaliacao.setNota(nota);
	                System.out.println("Valor da nota convertido: " + nota);
	            } catch (NumberFormatException e) {
	                System.out.println("Erro ao converter nota para inteiro: " + e.getMessage());
	            }
	        } else {
	            System.out.println("Nota está vazia ou nula.");
	        }

	        avaliacaoDao.inserirAvaliacao(avaliacao);

	        response.sendRedirect("main");
	    } else {
	        System.out.println("livroId está vazio ou nulo.");
	        // Trate de acordo com sua lógica de erro ou redirecione para uma página de erro
	    }
	}


	public int calcularMediaAvaliacoes(Long livroId) {
	    List<Avaliacao> avaliacoes = avaliacaoDao.listarAvaliacaoDoLivro(livroId);

	    if (avaliacoes.isEmpty()) {
	        return 0; // Ou outro valor padrão, caso não haja avaliações
	    }

	    int somaNotas = 0;
	    for (Avaliacao avaliacao : avaliacoes) {
	        somaNotas += avaliacao.getNota();
	    }

	    double media = (double) somaNotas / avaliacoes.size();
	    return Math.round((float) (media / 5) * 100);
	}

}
