<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="projeto.psd.entidades.Usuario"%>

<jsp:useBean id="dadosUsu" class="projeto.psd.entidades.Usuario" scope="session"/>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Pagina de Busca</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/navbar.css" rel="stylesheet">
        <link href="css/search.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    </head>
    <body>
        <%@include file="NavBar.htm"%>
        <div class="container">
        	<h1 id="textoCentral">Resultado da Busca</h1>
        	<hr>
        	<c:if test="${encontrados eq '[]'}">
        		<h1 id="textoCentral">Nenhum usuário cadastrado com esse nome</h1>
        	</c:if>
        	<c:forEach var="busca" items="${encontrados}">
	        	<div class="col-md-12">
	        	<div id="separador"></div>
	        		<div class="col-md-6">
	        			<img id="foto" src="${busca.fotoPerfil}">
	        		</div>
	        		<div class="col-md-5" id="dados">
		        		<br><br><br><br>
		        		<p><strong>Nome:</strong> ${busca.nome}</p>
		        		<p><strong>Cidade:</strong> ${busca.cidade}</p>
		        		<p><strong>Status:</strong> ${busca.status}</p>
		        		<form id="formulario" method="POST" action="front.do">
		        			<input name="email" type="text" value="${busca.email}" style="display: none;">
		        			<input type="hidden" name="action" value="BuscaUsu">
		        			<input class="button" type="submit" value="Visualizar Perfil">
		        		</form>
		        		<c:if test="${busca.email != dadosUsu.email}">
			        		<form id="formulario" method="POST" style="margin-left:40px" action="front.do">
			        			<input class="button" type="submit" value="Adicionar">
			        		</form>
		        		</c:if>
	        		</div>
	        	</div>
        	</c:forEach>
        </div>
    </body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
