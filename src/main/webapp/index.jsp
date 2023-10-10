<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Página - login</title>

<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="imglogin">
		<img src="imagens/logolivraria.jpeg">
	</div>
	<div class="login">

		<form name="frmUsuario" action="autenticador" method="post">
			<table>
				<tr>
					<td><input type="text" name="login" placeholder="Usuario"
						class="Caixa1"></td>
				</tr>
				<tr>
					<td><input type="password" name="senha" placeholder="Senha"
						class="Caixa1"></td>
				</tr>

			</table>
			<!--  <a href = "main" class="Botao1" > Entrar </a> -->
			 <input type="submit" value="Entrar" class="Botao1" onclick="return validar();">

		</form>

	</div>
	<script src="scripts/confirmarlogin.js"></script>

</body>
</html>