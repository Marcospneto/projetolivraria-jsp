<%@page import="br.com.jvm.projetolivraria.bean.AvaliacaoBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="br.com.jvm.projetolivraria.model.entidades.Livro"%>
<%@ page import="br.com.jvm.projetolivraria.model.entidades.Comentario"%>
<%@page import= "br.com.jvm.projetolivraria.bean.AvaliacaoBean" %>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
ArrayList<Livro> lista = (ArrayList<Livro>) request.getAttribute("livros");
%>



<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Sinopse</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css"
	rel="stylesheet" />
<link href="home.css" rel="stylesheet" />

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
%>

<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="main">Coffee Book</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar Search-->



		<form
			class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0"
			action="procurarLivro" method="get">
			<div class="input-group">
				<input class="form-control" type="text" name="titulo"
					placeholder="Search for..." aria-label="Search for..."
					aria-describedby="btnNavbarSearch" />
				<button class="btn btn-primary" id="btnNavbarSearch" type="submit">
					<i class="fas fa-search"></i>
				</button>
			</div>
		</form>




		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"><i
					class="fas fa-user fa-fw"></i></a>
				<ul class="dropdown-menu dropdown-menu-end"
					aria-labelledby="navbarDropdown">
					<!--     <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>-->
					<li><a class="dropdown-item" href="autenticador">Logout</a></li>

				</ul></li>
		</ul>
	</nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading">Core</div>
						<a class="nav-link" href="main">
							<div class="sb-nav-link-icon">
								<i class="fas fa-tachometer-alt"></i>
							</div> Pagina Inicial
						</a>
						
						<c:if test="${perfil == 'administrador'}" >
						<div class="sb-sidenav-menu-heading">Interface</div>
						<a class="nav-link collapsed" href="mainUsuario">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Usuários Cadastrados
						</a> 
						<a class="nav-link collapsed" href="novo.jsp">
							<div class="sb-nav-link-icon">
								<i class="fas fa-book-open"></i>
							</div> Adicionar Livro

						</a>
						</c:if>



					</div>
				</div>

			</nav>
		</div>

		<main>
			
			<!-- CONTEUDO PRINCIPAL -->

			<div class="container-principal2">


				<div class="container-comp">
					<div class="card2">
						<div class="img-card2">
							<img style="width: 100%; height: 665px;"
								src="imagens/newlogo.png">
						</div>
					</div>
				</div>

				<!-- Informações do Livro -->
				<div class="container-com">
					<div class="comp">
						<input type="hidden" name="id" class="form-control"
							value="<%out.print(request.getAttribute("id"));%>" readonly>
						
						<p><strong>Título</strong> <br><%out.print(request.getAttribute("titulo"));%></p>
						<p><strong>Genêro</strong><br><%out.print(request.getAttribute("genero"));%></p>
						<p><strong>Quantidade de Páginas</strong> <br><%out.print(request.getAttribute("quantidadePaginas"));%></p>
						<p><strong>Isbn</strong> <br><%=request.getAttribute("isbn")%></p>
						<p><strong>Autor</strong> <br><%out.print(request.getAttribute("autor"));%></p>
						<p><strong>Sinopse</strong> <br><%=request.getAttribute("sinopse")%></p>


					</div>
				</div>


			</div>



			




			<div class="afastar300">
				<%
    				Object avaliacaoObj = request.getAttribute("avaliacao");
    				int mediaAvaliacoes = avaliacaoObj != null ? Integer.parseInt(avaliacaoObj.toString()) : 0;
    				int numEstrelasPreenchidas = Math.round((float) mediaAvaliacoes / 20);
    				int numEstrelasBrancas = 5 - numEstrelasPreenchidas;

    				for (int i = 0; i < numEstrelasPreenchidas; i++) {
					%>
    					<span class="star">&#9733;</span>
					<%
   					 }

    				for (int i = 0; i < numEstrelasBrancas; i++) {
					%>
   					    <span class="star">&#9734;</span>
					<%
    				}
					%>
			
			
			
			


	<h5> Deixe uma avaliação sobre o livro!</h5>			
<!-- Form para inserir uma avaliação -->
<form name="frmAvaliacao" action="insertAvaliacao">
    <input type="hidden" name="livroId" value="<%= request.getParameter("id") %>">

    <ul class="avaliacao">
        <li class="star-icon" data-avaliacao="1"></li>
        <li class="star-icon" data-avaliacao="2"></li>
        <li class="star-icon" data-avaliacao="3"></li>
        <li class="star-icon" data-avaliacao="4"></li>
        <li class="star-icon" data-avaliacao="5"></li>
    </ul>

    <input type="hidden" id="nota" name="nota" value="0">

    <input type="button" value="Avalie" class="btn2 btn-primary2" onclick="validarAvaliacao()">
</form>

				
			






			
			
				<h5>Comentarios</h5>

				<%
				ArrayList<Comentario> comentarios = (ArrayList<Comentario>) request.getAttribute("comentario");
				if (comentarios != null) {
				for (Comentario comentario : comentarios) {
	            %>   
				<div class="comment-container">
					<div class="comment-box">
						<div class="user-info">
							 <span
								class="user-login"><i class="fas fa-user fa-fw"></i> <%=comentario.getUsuario().getLogin()%>
								</span>
						</div>
						<div class="comment-text">
							<%=comentario.getComentario()%>
						</div>
					</div>
				</div>
				<%
				}
				}
				%>


			</div>





			<div>
				<!-- Formulário de Comentário -->
				<form name="frmComentario" action="insertComentario">
					<input type="hidden" name="livroId"
						value="<%out.print(request.getParameter("id"));%>"> <input
						type="hidden" name="usuarioQueFezComentario"
						value="<%out.print(request.getSession().getAttribute("loginSession"));%>">

					<label>Click me </label>
				
					<textarea name="comentario" class="caixaComentario" maxlength="100"
						rows="5" placeholder="Digite seu comentário...">
					</textarea>



					<input type="button" value="Adicionar" class="btn2 btn-primary2"
						onclick="validarComentario()">
				</form>



			</div>







































		</main>


	</div>
	<script src="scripts/validadorAvaliacao.js"></script>
	<script src="scripts/validadorComentario.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
		crossorigin="anonymous"></script>
	<script src="assets/demo/chart-area-demo.js"></script>
	<script src="assets/demo/chart-bar-demo.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>

	
</body>
</html>