<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt=br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - CoffeBook</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div id="container">
        <div class="banner">
            <img src="imagens/newlogo.png">
            <p style="color: #000000; font-weight: 400;">
                Seja bem-vindo ao nosso sistema de avaliação de livros, <br>
                onde sua opinião literária é a peça-chave para enriquecer<br>
                nossa comunidade de leitores!
            </p>
        </div>

        <div class="box-login">
            <h1 class="h1BemVindo">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Olá!<br> Seja bem vindo
            </h1>

            <div class="box">
                <h2> Faça o seu login </h2>
                <form name="frmUsuario" action="autenticador" method="post">
    <table>
        <input type="text" name="login" placeholder="Usuario">
        <input type="password" name="senha" placeholder="Senha">
        
        <p id="login-error" style="color: red;"></p>
        <p id="senha-error" style="color: red;"></p>
        
        <% 
            String mensagemErro = (String) request.getAttribute("mensagemErro");
            if (mensagemErro != null && !mensagemErro.isEmpty()) { 
        %>
            <p id="mensagem-error" style="color: red;">
                <%= mensagemErro %>
            </p>
        <% } %>

    </table>
    <input type="submit" value="Entrar" class="buttonEntrar" onclick="return validarIndex();">
</form>

                
                <a href="criarConta.jsp">
                    <p>Criar uma conta</p>
                </a>
            </div>
        </div>
    </div>
    <script src="scripts/confirmarlogin.js"></script>
</body>
</html>
