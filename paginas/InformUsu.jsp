<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="projeto.psd.entidades.Usuario"%>

<jsp:useBean id="usuBus" class="projeto.psd.entidades.Usuario" scope="request"/>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Pagina de Busca</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/navbar.css" rel="stylesheet">
        <link href="css/inform.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    </head>
    <body>
        <%@include file="NavBar.htm"%>
        <div class="container">
        	<div class="col-md-12">
	        	<c:if test="${user.email eq emailUsuario}">
	        		<jsp:forward page="inicial.jsp"/>
	        	</c:if>
	        	<h1 id="textoCentral">Informações sobre o usuário</h1>
	        	<hr>
        		<div class="col-md-7">
        			<img src="${user.fotoPerfil}" width="400px" height="330px">
        			<br><br><br><br>
        		</div>
        		<div class="col-md-5" id="dados">
        			<p><strong>Nome:</strong> ${user.nome}</p>
                    <p><strong>Data de Nascimento: </strong> ${user.dataDeNascimento}</p>
                    <p><strong>Mora em:</strong> ${user.cidade}</p>
                    <p><strong>Profissao:</strong> ${user.profissao}</p>
                    <p><strong>Status de Relacionamento:</strong> ${user.status}</p>
                    <p><strong>Breve Descricao:</strong> ${user.descricao}</p>
                    <form id="formulario" method="POST" action="front.do">
	        			<input type="hidden" name="action" value="">
	        			<input class="button" type="submit" value="Mandar Convite">
	        		</form>
        		</div>
        	</div>
        </div>
    </body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>