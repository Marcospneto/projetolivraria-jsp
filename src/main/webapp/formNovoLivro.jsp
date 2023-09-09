<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --> 
<c:url value="/novo-livro" var="novoLivro" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Letra Digital</title>
</head>
<body>
	<form action="${novoLivro}" method="post">

		Titulo: <input type="text" name="titulo" /> <br><br> 
		Genero: <input type="text" name="genero"> <br><br>
		<input type="submit" />
	</form>
</body>
</html>