<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Novo Livro</title>
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
		<a class="navbar-brand ps-3" href="main">CoffeeBook</a>
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

						<div class="sb-sidenav-menu-heading">Interface</div>
						<a class="nav-link collapsed" href="mainUsuario">
							<div class="sb-nav-link-icon">
								<i class="fas fa-columns"></i>
							</div> Usu�rios Cadastrados
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
							<li class="breadcrumb-item active">Sua opni�o liter�ria � a
								pe�a-chave para enriquecer nossa comunidade de leitores!</li>
						</ol>
					</div>
				</div>

				<div class="container">
					<h1 class="titulo">Adicionar novo livro</h1>
					
					<form enctype="multipart/form-data" name="frmLivro" action="insert">
						<div class="form-group">
							<input type="text" name="titulo" placeholder="T�tulo"
								class="form-control">
						</div>
						<div class="form-group">
							<input type="text" name="genero" placeholder="G�nero"
								class="form-control">
						</div>
						<div class="form-group">
							<input type="text" name="quantidadePaginas"
								placeholder="Quantidade de P�ginas" class="form-control">
						</div>
						<div class="form-group">
							<input type="text" name="isbn" placeholder="ISBN"
								class="form-control">
						</div>
						<div class="form-group">
							<input type="text" name="sinopse" placeholder="Sinopse"
								class="form-control">
						</div>
						<div class="form-group">
							<input type="text" name="autor" placeholder="Autor"
								class="form-control">
						</div>
			
			<!--  
			<img alt="Imagem User" id="fotoembase64" src="" width="70px">
			
			
			
			<div class="form-group">
    
    			<label>Imagem do Livro:</label>
    					<input type="file" id="fileFoto" name="fileFoto" accept="image/*" 
					onchange="visualizarImg('fotoembase64','fileFoto');" class="form-control-file" 
					style="margin-top:15px; margin-left:5px;">
			</div>
		
		<button type="submit">Enviar</button>
		-->
						
					  	<input type="button" value="Adicionar" class="btn btn-primary"
							onclick="validar()">

					
					
				
					
					
					<!--  <input type="file" name="imagem" id="imagemLivro" 
    				class="form-control" placeholder="Imagem">-->
					
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
	<script>
	function visualizarImg(fotoembase64, filefoto) {

        var preview = document.getElementById(fotoembase64); //campo IMG html
        var fileUser = document.getElementById(filefoto).files[0];
        var reader = new FileReader();

        reader.onloadend = function () {
            preview.src = reader.result; //carrega a foto na tela

        };

        if (fileUser) {
            reader.readAsDataURL(fileUser); /Preview da imagem/
        }else {
            preview.src= '';
        }
    }
	</script>
</body>
</html>
