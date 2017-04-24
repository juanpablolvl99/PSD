<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="m" uri="RetornaMensagens"%>

<m:msgs email="${emailUsuario}"/>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Mensagens</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/search.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    </head>
    <body>
        <%@include file="NavBar2.jsp"%>
        <div class="container">
        	<div class="row">
       			<h1 id="textoCentral">Suas Mensagens</h1>
       			<hr>
        		<c:if test="empty ${mensagens}">
        			<h1>Não há nenhuma mensagem aqui</h1>
        		</c:if>
        		<div class="col-md-12">
        			<c:forEach var="msg" items="${mensagens}"> 
        				<div class="col-md-6">
        					<div class="col-md-6">
        						<p>De: ${msg.deEmail}</p>
        						<p>Mensagem: ${msg.mensagem}</p>
        					</div>
        					<div class="col-md-6">
        						<form action="front.do" method="post">
        							<input type="submit" class="btn btn-danger" value="Excluir">
        							<button class="btn btn-primary" style="display: inline-block;">Responder</button>
        						</form>
        					</div>
        				</div>
        			</c:forEach>	
        		</div>
        	</div>
        </div>
    </body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>