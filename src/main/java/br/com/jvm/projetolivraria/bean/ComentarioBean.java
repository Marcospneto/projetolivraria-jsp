package br.com.jvm.projetolivraria.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jvm.projetolivraria.model.dao.ComentarioDao;
import br.com.jvm.projetolivraria.model.entidades.Comentario;
import br.com.jvm.projetolivraria.model.entidades.Livro;
import br.com.jvm.projetolivraria.model.entidades.Usuario;

public class ComentarioBean {
	ComentarioDao comentarioDao = new ComentarioDao();
	Comentario comentario = new Comentario();
	Usuario usuario = new Usuario();
	Livro livro = new Livro();
	java.util.Date dataAtual = new java.util.Date();
	
	
	
	public void inserirComentario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String livroId = request.getParameter("livroId");
	    String usuarioQueFezComentario = request.getParameter("usuarioQueFezComentario");
		livro.setId(Long.parseLong(livroId));
		comentario.setLivro(livro);
	    
		usuario.setLogin(usuarioQueFezComentario);
		comentario.setUsuario(usuario);
	    

		
		  comentario.setComentario(request.getParameter("comentario"));
		
		  java.sql.Date dataSql = new java.sql.Date(dataAtual.getTime());
	   	  comentario.setData_comentario(dataSql);
		
		  comentarioDao.inserirComentario(comentario);
		
		  response.sendRedirect("main");
		
	}
	

}
