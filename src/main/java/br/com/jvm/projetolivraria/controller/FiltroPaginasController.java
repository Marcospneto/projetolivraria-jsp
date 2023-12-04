package br.com.jvm.projetolivraria.controller; 

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/main", "/novo.jsp", "/select", "/detalheLivro", "/procurarLivro",
		"/usuarioSelect", "/mainUsuario"})
public class FiltroPaginasController implements Filter {

	public FiltroPaginasController() {

	}

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest.getRequestURI();
		
		HttpSession sessao = httpServletRequest.getSession();
		
		String perfil = (String) sessao.getAttribute("perfil");
		
		
		
		if (sessao.getAttribute("usuAutenticado") != null || url.lastIndexOf("index.jsp")>-1
				|| url.lastIndexOf("autenticador") >-1 || "administrador".equals(perfil)) {
		
		
			
			chain.doFilter(request, response); 
		} else {
			((HttpServletResponse) response).sendRedirect("index.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
