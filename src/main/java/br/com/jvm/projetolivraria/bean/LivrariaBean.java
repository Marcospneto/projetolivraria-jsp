package br.com.jvm.projetolivraria.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.utils.IOUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.codec.binary.Base64;
//import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.jvm.projetolivraria.model.dao.ComentarioDao;
import br.com.jvm.projetolivraria.model.dao.LivrariaDao;
import br.com.jvm.projetolivraria.model.entidades.Comentario;
import br.com.jvm.projetolivraria.model.entidades.Livro;

@MultipartConfig
public class LivrariaBean {
	LivrariaDao livrariaDao = new LivrariaDao();
	Livro livro = new Livro();
	ComentarioDao comentarioDao = new ComentarioDao();
	AvaliacaoBean avaliacaoBean = new AvaliacaoBean();
	// Listar Livros
	public void livros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		RequestDispatcher rd = request.getRequestDispatcher("principal/livraria.jsp");
		rd.forward(request, response);
	}

	
	
	
	
	public void novoLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis Livro
		livro.setTitulo(request.getParameter("titulo"));
		livro.setGenero(request.getParameter("genero"));
		livro.setQuantidadePaginas(request.getParameter("quantidadePaginas"));
		livro.setIsbn(request.getParameter("isbn"));
		livro.setSinopse(request.getParameter("sinopse"));
		livro.setAutor(request.getParameter("autor"));
		
		//livro.setImagem(request.getParameter("imagem"));
		/*System.out.println("Chegou nao:" + request.getPart("fileFoto"));
		Part part = request.getPart("fileFoto");
		System.out.println("Chegou nao:" + part);
        if (part.getSize() > 0 ) {
            byte[] foto = IOUtils.toByteArray(part.getInputStream());
            new Base64();
            String imagemBase64 = "data:image/" + part.getContentType().split("\\/")[1] + ";base64," + Base64.encodeBase64String(foto);

            livro.setImagem(imagemBase64);
            livro.setExtensaoImg(part.getContentType().split("\\/")[1]);

        }else {
            System.out.println("Nenhuma foto foi enviada");
        }
		*/
		
        // invocar o metodo inserirLivro passando o objeto livro
		livrariaDao.inserirLivro(livro);
		// Redirecionar para o documento livraria.jsp
		response.sendRedirect("main");

	}

	
	
	public void listarLivro(HttpServletRequest request, HttpServletResponse response)
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
		request.setAttribute("id", livro.getId());
		request.setAttribute("titulo", livro.getTitulo());
		request.setAttribute("genero", livro.getGenero());
		request.setAttribute("quantidadePaginas", livro.getQuantidadePaginas());
		request.setAttribute("isbn", livro.getIsbn());
		request.setAttribute("sinopse", livro.getSinopse());
		request.setAttribute("autor", livro.getAutor());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("principal/editar.jsp");
		rd.forward(request, response);
		
	}

	
	

	public void detalheLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		Long id = null;
		try {
			id = Long.parseLong(idStr);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Livro livro = new Livro();
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
		request.setAttribute("sinopse", livro.getSinopse());
		request.setAttribute("autor", livro.getAutor());
		System.out.println("ID do Livro: " + livro.getId());
		List<Comentario> comentarios = comentarioDao.listarComentariosDoLivro(livro.getId());
		livro.setComentarios(comentarios);
		//Teste para ver se o comentario está sendo recuperado
		//System.out.println("Se tiver comentario aparece aqui: " + livro.getComentarios());
		request.setAttribute("comentario", comentarios);
		
		int mediaAvaliacoes = avaliacaoBean.calcularMediaAvaliacoes(livro.getId());
		livro.setAvaliacao(mediaAvaliacoes);
		request.setAttribute("avaliacao", mediaAvaliacoes);
		
		request.setAttribute("imagem", livro.getImagem());
		
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("detalheLivro.jsp");
		rd.forward(request, response);

	}


	
	
	
	public void procurarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String livroTitulo = request.getParameter("titulo");

		Livro livro = livrariaDao.procurarLivroPorTitulo(livroTitulo);

		if (livro != null) {
			// Livro encontrado, redirecionar para a página procurarLivro.jsp
			request.setAttribute("livroEncontrado", livro);
			RequestDispatcher rd = request.getRequestDispatcher("procurarLivro.jsp");
			rd.forward(request, response);
		} else {
			// Livro não encontrado, redirecionar para a página livroNaoEncontrado.jsp
			response.sendRedirect("livroNaoEncontrado.jsp");
		}
	}

	
	
	
	
	public void editarLivro(HttpServletRequest request, HttpServletResponse response)
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
		livro.setSinopse(request.getParameter("sinopse"));
		livro.setAutor(request.getParameter("autor"));
		// Executar o metodo alterarLivro
		livrariaDao.alterarLivro(livro);
		// Redirecionar para o documento livraria.jsp (atualizando as alterações)
		response.sendRedirect("main");

	}

	
	
	
	
	public void removerLivro(HttpServletRequest request, HttpServletResponse response)
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

	
	
	
	
	// Gerar Relatório em PDF
	public void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// Tipo de conteudo
			response.setContentType("apllication/pdf");
			// Nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "livros.pdf");
			// Criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// Abrir o documento para gerar o conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de livros:"));
			documento.add(new Paragraph(" "));
			// Criar uma tabela
			PdfPTable tabela = new PdfPTable(4);
			// Cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Titulo"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Genero"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Quantidade de paginas"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Isbn"));
			PdfPCell col5 = new PdfPCell(new Paragraph("sinopse"));
			PdfPCell col6 = new PdfPCell(new Paragraph("autor"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			// Popular a tabela com os livros
			ArrayList<Livro> lista = livrariaDao.listarLivros();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getTitulo());
				tabela.addCell(lista.get(i).getGenero());
				tabela.addCell(lista.get(i).getQuantidadePaginas());
				tabela.addCell(lista.get(i).getIsbn());
				tabela.addCell(lista.get(i).getSinopse());
				tabela.addCell(lista.get(i).getAutor());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}

}
