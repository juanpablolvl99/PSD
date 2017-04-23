<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="myTags" uri="VerificaPedido"%>

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
        <%@include file="NavBar2.jsp"%>
        <div class="container">
        	<h1 id="textoCentral">Resultado da Busca</h1>
        	<hr>
        	<c:if test="${encontrados eq '[]'}">
        		<h1 id="textoCentral">Nenhum usuário cadastrado com esse nome</h1>
        	</c:if>
        	<c:forEach var="busca" items="${encontrados}">
	        	<div class="col-md-6">
	        	<div id="separador"></div>
	        		<div class="col-md-7">
	        			<img id="foto" src="${busca.fotoPerfil}" style="width: 100%">
	        		</div>
	        		<div class="col-md-5" id="dados">
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
	        		</div>
	        	</div>
        	</c:forEach>
        </div>
    </body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
