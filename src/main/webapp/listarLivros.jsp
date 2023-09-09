<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List, br.com.jvm.projetolivraria.model.entidades.Livro"%>

<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> -->

<c:url value="/listar-livros" var="listarLivros" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Livraria Facol </title>
</head>
<body>

	Listando Livros cadastrados:
	<br />

	<ul>
		<c:forEach items="${livros}" var="livro">
			<li>${livro.titulo}
				<a href="">editar</a>
				<a href="">remover</a>
			</li>
		</c:forEach>

	</ul>

</body>
</html>