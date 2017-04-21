<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="myTags" uri="VerificaPedido"%>
<%@page import="projeto.psd.entidades.Usuario"%>

<jsp:useBean id="dadosUsu" class="projeto.psd.entidades.Usuario" scope="session"/>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Pagina de Busca</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
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
	        	<div class="col-md-6">
	        	<div id="separador"></div>
	        		<div class="col-md-6">
	        			<img id="foto" src="${busca.fotoPerfil}">
	        		</div>
	        		<div class="col-md-6" id="dados">
		        		<br><br><br>
		        		<p><strong>Nome:</strong> ${busca.nome}</p>
		        		<p><strong>Cidade:</strong> ${busca.cidade}</p>
		        		<p><strong>Status:</strong> ${busca.status}</p>
		        		<form style="margin-left: 5%" id="formulario" method="POST" action="front.do">
		        			<input name="nomeUsuario" type="hidden" value="${busca.nome}" >
		        			<input name="email" type="hidden" value="${busca.email}">
		        			<input type="hidden" name="action" value="BuscaUsu">
		        			<input style="margin-left: 10%" class="button" type="submit" value="Visualizar Perfil">
		        		</form>
		        		<myTags:verificaPedido deEmail="${dadosUsu.email}" paraEmail="${busca.email}"/>
		        		<c:if test="${busca.email != dadosUsu.email}">
		        			<c:if test="${cond}">
				        		<form id="formulario" method="POST" style="margin-left: 10%" action="front.do">
				        			<input type="hidden" name="deUsuario" value="${dadosUsu.email}">
				        			<input type="hidden" name="paraUsuario" value="${busca.email}">
				        			<input type="hidden" name="action" value="Convite">
				        			<input class="button" type="submit" value="Mandar Convite">
				        		</form>
			        		</c:if>
		        		</c:if>
	        		</div>
	        	</div>
        	</c:forEach>
        </div>
    </body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
