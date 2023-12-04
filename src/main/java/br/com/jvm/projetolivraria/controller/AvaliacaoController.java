package br.com.jvm.projetolivraria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jvm.projetolivraria.bean.AvaliacaoBean;


@WebServlet(urlPatterns = {"/insertAvaliacao"})
public class AvaliacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AvaliacaoBean avaliacaoBean = new AvaliacaoBean();
	
    
	public AvaliacaoController() {
        super();
        
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		if (action.equals("/insertAvaliacao")) {
			avaliacaoBean.novaAvaliacao(request, response);
		}else {
			response.sendRedirect("home.jsp");
		}
		
	}
}
