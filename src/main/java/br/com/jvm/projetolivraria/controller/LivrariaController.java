package br.com.jvm.projetolivraria.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jvm.projetolivraria.model.dao.LivrariaDao;
import br.com.jvm.projetolivraria.model.entidades.Livro;

@WebServlet(urlPatterns = { "/LivrariaController", "/main", "/insert", "/select", "/update", "/delete" })
public class LivrariaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LivrariaDao livrariaDao = new LivrariaDao();
	Livro livro = new Livro();

	public LivrariaController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			livros(request, response);
		} else if (action.equals("/insert")) {
			novoLivro(request, response);
		} else if (action.equals("/select")) {
			listarLivro(request, response);
		} else if (action.equals("/update")) {
			editarLivro(request, response);
		} else if (action.equals("/delete")) {
			removerLivro(request, response);
		} else {
			response.sendRedirect("index.html");
		}
		/*
		 * //Teste de conexão livrariaDao.testeConexao();
		 */
	}

	// Listar Livros
	protected void livros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados Livro
		ArrayList<Livro> lista = livrariaDao.listarLivros();
		/*
		 * //Teste de recebimento da lista for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getId());
		 * System.out.println(lista.get(i).getTitulo());
		 * System.out.println(lista.get(i).getGenero());
		 * System.out.println(lista.get(i).getQuantidadePaginas());
		 * System.out.println(lista.get(i).getIsbn()); }
		 */
		// Encaminhar a lista ao documento livraria.jsp
		request.setAttribute("livros", lista);
		RequestDispatcher rd = request.getRequestDispatcher("livraria.jsp");
		rd.forward(request, response);
	}

	// Novo Livro
	protected void novoLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis Livro
		livro.setTitulo(request.getParameter("titulo"));
		livro.setGenero(request.getParameter("genero"));
		livro.setQuantidadePaginas(request.getParameter("quantidadePaginas"));
		livro.setIsbn(request.getParameter("isbn"));
		// invocar o metodo inserirLivro passando o objeto livro
		livrariaDao.inserirLivro(livro);
		// Redirecionar para o documento livraria.jsp
		response.sendRedirect("main");

	}

	// Editar Livro
	protected void listarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Long id = null;
		try {
			id = Long.parseLong(idStr);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Setar a variavel Livro
		livro.setId(id);
		// Executar o método selecionarLivro (DAO)
		livrariaDao.selecionarLivro(livro);
		// Setar os atributos do formulario com o conteudo Livro
		request.setAttribute("id", livro.getId());
		request.setAttribute("titulo", livro.getTitulo());
		request.setAttribute("genero", livro.getGenero());
		request.setAttribute("quantidadePaginas", livro.getQuantidadePaginas());
		request.setAttribute("isbn", livro.getIsbn());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	protected void editarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Long id = null;
		try {
			id = Long.parseLong(idStr);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Setar as variaveis Livro
		livro.setId(id);
		livro.setTitulo(request.getParameter("titulo"));
		livro.setGenero(request.getParameter("genero"));
		livro.setQuantidadePaginas(request.getParameter("quantidadePaginas"));
		livro.setIsbn(request.getParameter("isbn"));
		// Executar o metodo alterarLivro
		livrariaDao.alterarLivro(livro);
		// Redirecionar para o documento livraria.jsp (atualizando as alterações)
		response.sendRedirect("main");

	}

	// Remover Livro
	protected void removerLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do livro a ser excluido (validador.js)

		String idStr = request.getParameter("id");
		Long id = null;
		try {
			id = Long.parseLong(idStr);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Setar a variavel id Livro
		livro.setId(id);
		// Executar o metodo deletarLivro (DAO) passando o objeto livro
		livrariaDao.deletarLivro(livro);
		// Redirecionar para o documento livraria.jsp (atualizando as alterações)
		response.sendRedirect("main");

	}

}
