<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="myTags" uri="RetornaUsuEmail"%>
<%@taglib prefix="myTgs" uri="CarregaPedidos"%>

<myTgs:carPedidos/>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Convites</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/search.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <body>
        <%@include file="NavBar2.jsp"%>
        <div class="container">
        	<div class="col-md-12">
	        	<div class="col-md-6">
	        		<h2 style="color: black; text-align: center;">Convites Feitos</h2><br>
	        		<c:forEach var="i" items="${convites}" varStatus="teste">
		        		<c:if test="${i.userEmail eq emailUsuario}">
			        		<div class="w3-row w3-container" style="margin:10% 0">
					        		<myTags:retornaUsu email="${i.userParaEmail}"></myTags:retornaUsu>
									<div class="w3-half w3-container">
									  <div class="w3-topbar w3-border-amber">
									    <img src="${otherUser.fotoPerfil}" style="width:100%">
									    <form action="front.do" method="POST" style="margin: 4% 11%">
									    	<input type="hidden" name="action" value="ExcluirPedido">
						        			<input type="hidden" name="deEmail" value="${emailUsuario}">
						        			<input type="hidden" name="paraEmail" value="${i.userParaEmail}">
						        			<input class="button" type="submit" value="Cancelar Convite">
						        		</form>
									  </div>
									</div>
									<div class="w3-half w3-container">
									    <div id="centralizar">
									    <h2>${otherUser.nome}</h2>
					        				<p><b>Status:</b> ${otherUser.status}</p>
					        				<p><b>Breve Descricao:</b> ${otherUser.descricao}</p>
					        			</div>
									</div>
			        			</div>
		        			</c:if>
	        		</c:forEach>
	        	</div>
	        	<div class="col-md-6">
	        		<h2 style="color: black; text-align: center;">Convites Recebidos</h2><br>
	        		<c:forEach var="i" items="${convites}">
	        			<c:if test="${i.userParaEmail eq emailUsuario}">
	        			<div class="w3-row w3-container" style="margin:10% 0">
					        		<myTags:retornaUsu email="${i.userEmail}"></myTags:retornaUsu>
									<div class="w3-half w3-container">
									  <div class="w3-topbar w3-border-amber">
									    <img src="${otherUser.fotoPerfil}" style="width:100%">
									    <div class="w3-half w3-container">
									    <form id="formulario" action="front.do" method="POST" style="margin:20% -15%">
			        						<input type="hidden" name="action" value="AceitarAmizade">
			        						<input type="hidden" name="deEmail" value="${emailUsuario}">
			        						<input type="hidden" name="paraEmail" value="${i.userEmail}">
			        						<input class="button" type="submit" value="Aceitar" style="width: 80px; height: 40px;">
			        					</form>
			        					</div>
			        					<div class="w3-half w3-container">
			        					<form id="formulario" method="POST" action="front.do" style="margin:20% -15%">
			        						<input type="hidden" name="action" value="ExcluirPedido">
			        						<input type="hidden" name="deEmail" value="${i.userEmail}">
			        						<input type="hidden" name="paraEmail" value="${emailUsuario}">
			        						<input class="button" type="submit" value="Cancelar" style="width: 90px; height: 40px;">
			        					</form>
			        					</div>
									  </div>
									</div>
									<div class="w3-half w3-container">
									    <div id="centralizar">
									    <h2>${otherUser.nome}</h2>
					        				<p><b>Status:</b> ${otherUser.status}</p>
					        				<p><b>Breve Descricao:</b> ${otherUser.descricao}</p>
					        			</div>
									</div>
			        			</div>
	        			</c:if>
	        		</c:forEach>
	        	</div>
        	</div>
        	<c:if test="${empty convites}">
        		<h2 style="color: black; text-align: center;">Nenhum Convite Feito</h2>
        	</c:if>
        </div>
    </body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>