package br.com.jvm.projetolivraria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jvm.projetolivraria.bean.ComentarioBean;
import br.com.jvm.projetolivraria.model.entidades.Comentario;


@WebServlet(urlPatterns = {"/insertComentario"})
public class ComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ComentarioBean comentarioBean = new ComentarioBean();
    Comentario comentario = new Comentario();
   
    public ComentarioController() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getServletPath();
			
			System.out.println(action);
			if(action.equals("/insertComentario")) {
				comentarioBean.inserirComentario(request, response);
			}else {
				response.sendRedirect("home.jsp");
			}
		
		
		
		
		}



}
