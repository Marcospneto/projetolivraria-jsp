package br.com.jvm.projetolivraria.bean;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.jvm.projetolivraria.model.dao.UsuarioDao;
import br.com.jvm.projetolivraria.model.entidades.Usuario;

public class UsuarioBean {
	UsuarioDao usuarioDao = new UsuarioDao();
	Usuario usuario = new Usuario();

	public void usuarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados Usuario
		ArrayList<Usuario> lista = usuarioDao.listarUsuario();
		// Encaminhar a lista ao documento usuariosCadastrados.jsp
		request.setAttribute("usuarios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("usuariosCadastrados.jsp");
		rd.forward(request, response);

	}

	public void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String perfilPadrao = "usuario";

		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		if (login == null || login.isEmpty() || senha == null || senha.isEmpty()) {
			// Campos de login ou senha estão vazios
			// Redireciona de volta para a página criar conta com uma mensagem de erro
			response.sendRedirect("criarConta.jsp?error=1");
			return;

		}
		if (senha.length() < 8) {
			// A senha é muito curta
			// Redirecione com uma mensagem de erro
			response.sendRedirect("criarConta.jsp?error=2");
			return;
			// Verifique se o login já existe no banco de dados

		}
		if (usuarioDao.loginExiste(login)) {
			// O login já existe, redirecione com uma mensagem de erro
			response.sendRedirect("criarConta.jsp?error=3");
			return;

		} else {// Setar as variáveis Usuario
			usuario.setLogin(request.getParameter("login"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setPerfil(perfilPadrao);

			// Invocar o metodo inserirUsuario passando o objeto usuario
			usuarioDao.inserirUsuario(usuario);
			// Redirecionar para a pagina index.jsp
			response.sendRedirect("index.jsp");

		}
	}

	// É responsavel por exibir informações de um usuario especifico
	public void listarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Long id = null;
		try {
			id = Long.parseLong(idStr);
		} catch (Exception e) {
			System.out.println(e);
		}

		// Setar a variável Usuario
		usuario.setId(id);
		// Executa o metodo selecionarUsuario(DAO)
		usuarioDao.selecionarUsuario(usuario);
		// Setar os atributos do formulario com o conteudo Usuario
		request.setAttribute("id", usuario.getId());
		request.setAttribute("login", usuario.getLogin());
		request.setAttribute("perfil", usuario.getPerfil());
		System.out.println("Mais homi pq ta vindo errado?" + usuario.getPerfil());
		// Encaminhar ao documento editarUsuario.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editarUsuario.jsp");
		rd.forward(request, response);
	}

	public void editarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Long id = null;
		try {
			id = Long.parseLong(idStr);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Setar as variaveis Usuario
		usuario.setId(id);
		usuario.setPerfil(request.getParameter("perfil"));
		// Executar o metodo alterarUsuario
		usuarioDao.alterarUsuario(usuario);
		// Redirecionar para o documento usuariosCadastrados.jsp (Atualizando as
		// informações)
		response.sendRedirect("main");

	}
	
	// Remover Usuario
		public void removerUsuario(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Recebimento do id do usuario a ser excluido (validador.js)

			String idStr = request.getParameter("id");
			Long id = null;
			try {
				id = Long.parseLong(idStr);
			} catch (Exception e) {
				System.out.println(e);
			}
			// Setar a variavel id Livro
			usuario.setId(id);
			// Executar o metodo deletarLivro (DAO) passando o objeto livro
			usuarioDao.deletarUsuario(usuario);
			// Redirecionar para o documento livraria.jsp (atualizando as alterações)
			response.sendRedirect("usuariosCadastrados");

		}

}
