<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Editar Livro</title>
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
		<a class="navbar-brand ps-3" href="main">CoffeBook</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
			id="sidebarToggle" href="#!">
			<i class="fas fa-bars"></i>
		</button>



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

						<div class="sb-sidenav-menu-heading">Interface</div>
						<a class="nav-link collapsed" href="mainUsuario">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Usuários Cadastrados
						</a> <a class="nav-link collapsed" href="novo.jsp">
							<div class="sb-nav-link-icon">
								<i class="fas fa-book-open"></i>
							</div> Adicionar Livro
						</a>

					</div>
				</div>

			</nav>
		</div>

		<main>
			<!-- CONTEUDO PRINCIPAL -->

			<div class="container-principal">

				<div class="session-title-cards">
					<div class="container-fluid px-4">
						<h1 class="mt-4">CoffeBook</h1>
						<ol class="breadcrumb mb-4">
							<li class="breadcrumb-item active">Sua opnião literária é a
								peça-chave para enriquecer nossa comunidade de leitores!</li>
						</ol>
					</div>
				</div>

				<div class="container">
					<h1 class="titulo">Editar Livro</h1>

					<form name="frmLivro" action="update">

						<div class="form-group">
							<input type="text" name="id" id="form-control" readonly
								style="display: none;"
								value="<%out.print(request.getAttribute("id"));%>">
						</div>
						<div class="form-group">
							<p class="pForm">Titulo</p>
							<input type="text" name="titulo" class="form-control"
								value="<%out.print(request.getAttribute("titulo"));%>">
						</div>
						<div class="form-group">
						<p class="pForm">Genero</p>
							<input type="text" name="genero" class="form-control"
								value="<%out.print(request.getAttribute("genero"));%>">
						</div>
						<div class="form-group">
							<p class="pForm">Quantidade de páginas</p>
							<input type="text" name="quantidadePaginas" class="form-control"
								value="<%out.print(request.getAttribute("quantidadePaginas"));%>">
						</div>
						<div class="form-group">
							<p class="pForm">Isbn</p>
							<input type="text" name="isbn" class="form-control"
								value="<%out.print(request.getAttribute("isbn"));%>">
						</div>
						<div class="form-group">
						<p class="pForm">Sinopse</p>
							<input type="text" name="sinopse" class="form-control"
								value="<%out.print(request.getAttribute("sinopse"));%>">
						</div>
						<div class="form-group">
						<p class="pForm">Autor</p>
							<input type="text" name="autor" class="form-control"
								value="<%out.print(request.getAttribute("autor"));%>">
						</div>


						<input type="button" value="Salvar" class="btn btn-primary"
							onclick="validar()">

					</form>


				</div>
				<script src="scripts/validador.js"></script>


			</div>




		</main>


	</div>
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
