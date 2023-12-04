<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt=br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Criar Conta</title>

<!--CSS-->
<link rel="stylesheet" href="style.css">



</head>
<body>
	<div id="container">
		<div class="banner">
			<img src="imagens/newlogo.png">
			<p style="color: #000000; font-weight: 400;">
				Seja bem-vindo ao nosso sistema de avaliação de livros, <br>onde
				sua opinião literária é a peça-chave para enriquecer<br>nossa
				comunidade de leitores!
			</p>
		</div>

		<div class="box-login">
			<h1>
				Junte-se a nós,<br>Crie hoje a sua conta!
			</h1>

			<div class="box-account">
				<h2>informe seus dados</h2>
				<form name="frmUsuario" action="insertUsuario">
					<input type="text" name="login" placeholder="Usuario">
				    <input type="password" name="senha" placeholder="Senha">
						 <p id="login-error" style="color: red;"></p>
						 <p id="senha-error" style="color: red;"></p>
						 


					<div class="check">
						<input type="checkbox" name="termo" id="termo"
							style="width: 13px; height: 13px;"> <label for="termos"
							style="color: #3d3d3d;">li e aceito os termos</label>
					</div>

					<input type="submit" value="Criar Conta" class="buttonEntrar"
						onclick="return validarLogin();">
				</form>
			</div>
		</div>
	</div>

	<a href="index.jsp"></a>

	<script src="scripts/confirmarlogin.js"></script>
</body>
</html>