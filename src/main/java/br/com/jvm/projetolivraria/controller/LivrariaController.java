package br.com.jvm.projetolivraria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jvm.projetolivraria.bean.LivrariaBean;
import br.com.jvm.projetolivraria.model.entidades.Livro;

@WebServlet(urlPatterns = { "/LivrariaController", "/main", "/insert", "/select", "/update", "/delete",
		"/report", "/detalheLivro", "/procurarLivro" })
public class LivrariaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LivrariaBean livrariaBean = new LivrariaBean();
	

	public LivrariaController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		System.out.println(action);
		if (action.equals("/main")) {
			livrariaBean.livros(request, response);
		} else if (action.equals("/insert")) {
			livrariaBean.novoLivro(request, response);
		} else if (action.equals("/procurarLivro")) {
			livrariaBean.procurarLivro(request, response);
	    }  else if (action.equals("/select")) {
			livrariaBean.listarLivro(request, response);
		} else if (action.equals("/update")) {
			livrariaBean.editarLivro(request, response);
		} else if (action.equals("/delete")) {
			livrariaBean.removerLivro(request, response);
		} else if (action.equals("/report")) {
			livrariaBean.gerarRelatorio(request, response);
		}else if (action.equals("/detalheLivro")) {
	        livrariaBean.detalheLivro(request, response);
	    } else {
			response.sendRedirect("home.jsp");
		}
		
	}
}
