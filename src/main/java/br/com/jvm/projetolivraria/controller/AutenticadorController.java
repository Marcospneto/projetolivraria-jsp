package br.com.jvm.projetolivraria.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.jvm.projetolivraria.connection.ConnectionBanco;
import br.com.jvm.projetolivraria.model.dao.UsuarioDao;
import br.com.jvm.projetolivraria.model.entidades.Usuario;

@WebServlet(urlPatterns = "/autenticador")
public class AutenticadorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuarioDao usuarioDao = new UsuarioDao();
	private static ConnectionBanco connectionBanco = new ConnectionBanco();

	public AutenticadorController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sessao = request.getSession(false);
		if (sessao != null) {
			sessao.invalidate();
		}
		response.sendRedirect("index.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			Usuario usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);

			UsuarioDao usuarioDao = new UsuarioDao();
			Usuario usuAutenticado = usuarioDao.autenticarUsuario(usuario);

			if (usuAutenticado != null) {
			    HttpSession sessao = request.getSession();
			    sessao.setAttribute("usuAutenticado", usuAutenticado);

			    String perfil = usuAutenticado.getPerfil();
			    System.out.println("Ta por aq:" + perfil);
			    String loginSession = usuAutenticado.getLogin();
			    
			    sessao.setAttribute("loginSession", loginSession);
			    sessao.setAttribute("perfil", perfil);
			    
			    if ("administrador".equals(perfil)) {
			        sessao.setAttribute("perfil", "administrador");
			    } else {
			        sessao.setAttribute("perfil", "usuario");
			    }
			    
			    response.sendRedirect("main");
			} // Se a autenticação falhar
			// Se a autenticação falhar
			else {
			    request.setAttribute("mensagemErro", "Conta inválida!");
			    request.getRequestDispatcher("index.jsp").forward(request, response);
			}



			


		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
