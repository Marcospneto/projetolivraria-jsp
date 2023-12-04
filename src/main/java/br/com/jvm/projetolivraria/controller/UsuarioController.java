package br.com.jvm.projetolivraria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jvm.projetolivraria.bean.UsuarioBean;
import br.com.jvm.projetolivraria.model.entidades.Usuario;

@WebServlet(urlPatterns = { "/insertUsuario", "/mainUsuario", "/usuarioUpdate", "/usuarioSelect" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioBean usuarioBean = new UsuarioBean();
	Usuario usuario = new Usuario();

	public UsuarioController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		System.out.println(action);
		if (action.equals("/insertUsuario")) {
			usuarioBean.novoUsuario(request, response);
		} else if (action.equals("/mainUsuario")) {
			usuarioBean.usuarios(request, response);
		} else if (action.equals("/usuarioSelect")) {
			usuarioBean.listarUsuario(request, response);
		} else if (action.equals("/usuarioUpdate")) {
			usuarioBean.editarUsuario(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}

	}

}
