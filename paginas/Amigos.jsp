<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="RetornaAmigos" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Pagina de Busca</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/search.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
		<script src="js/jquery.min.js"></script>
    </head>
    <body>
        <%@include file="NavBar2.jsp"%>
        <f:friends email="${emailUsuario}"/>
        <div class="container">
        	<h1 id="textoCentral">Seus amigos</h1>
        	<hr>
        	<c:if test="${empty amigos}">
        		<h1 id="textoCentral">Você ainda não possui nem UM amigo</h1>
        	</c:if>
        	<c:forEach var="busca" items="${amigos}">
	        	<div class="col-md-8">
	        	<div id="separador"></div>
	        		<div class="col-md-5">
	        			<img id="foto" src="${busca.fotoPerfil}" style="width: 100%">
	        		</div>
	        		<div class="col-md-7" id="dados">
		        		<br><br><br>
		        		<p><strong>Nome:</strong> ${busca.nome}</p>
		        		<p><strong>Cidade:</strong> ${busca.cidade}</p>
		        		<p><strong>Status:</strong> ${busca.status}</p>
		        		<form style="margin-left: 3%" id="formulario" method="POST" action="front.do">
		        			<input name="nomeUsuario" type="hidden" value="${busca.nome}" >
		        			<input name="email" type="hidden" value="${busca.email}">
		        			<input type="hidden" name="action" value="BuscaUsu">
		        			<input style="margin-left: 8%" class="button" type="submit" value="Visualizar Perfil">
		        		</form>
		        		<button class="button" style="padding: 13.5px 5px 13.5px 5px" id="show">Mandar mensagem</button>
		        		<form method="post" action="front.do" style="margin-left: 3%">
		        			<input type="" name="mensagem" class="form-control" style="display: inline-block; width: 75%; display: none" id="mensagem">
		        			<input type="hidden" name="action" value="Mensagem">
		        			<input type="hidden" name="pagina" value="amigos">
		        			<input type="hidden" name="emailDe" value="${emailUsuario}">
		        			<input type="hidden" name="emailPara" value="${busca.email}">
		        			<input type="submit" class="button" name="" style="margin-left: 2%; display: none" id="enviar">
		        		</form>
		        		<script type="text/javascript">
		        			$(document).ready(function(){
		        					$("#show").click(function(){
		        						if($("#mensagem").css("display")=="none"){
			        						$("#mensagem").css("display", "inline-block");
			        						$("#enviar").css("display", "inline-block");
			        					}else{		
		        							$("#mensagem").css("display", "none");
		        							$("#enviar").css("display", "none");
		        						}
		        					});
		        				
		        			});
		        		</script>
	        		</div>
	        	</div>
        	</c:forEach>
        </div>
    </body>
<script src="js/bootstrap.min.js"></script>
</html>