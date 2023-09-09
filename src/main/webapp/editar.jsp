<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Livraria</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar livro</h1>
	<form name="frmLivro" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="caixa3" readonly
				 value="<%out.print(request.getAttribute("id")); %>"></td>
			</tr>
			<tr>
				<td><input type="text" name="titulo" class="Caixa1"
				 value="<%out.print(request.getAttribute("titulo"));%>">></td>
			</tr>
			<tr>
				<td><input type="text" name="genero" class="Caixa1"
				 value="<%out.print(request.getAttribute("genero")); %>">></td>
			</tr>
			<tr>
				<td><input type="text" name="quantidadePaginas" class="Caixa2"
				 value="<%out.print(request.getAttribute("quantidadePaginas")); %>">></td>
			</tr>
			<tr>
				<td><input type="text" name="isbn" class="Caixa2"
				 value="<%out.print(request.getAttribute("isbn")); %>">></td>
			</tr>

		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">

	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>