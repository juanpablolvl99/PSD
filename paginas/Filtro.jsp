<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Pagina de Busca</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/search.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    </head>
    <body>
    	<jsp:include page="NavBar2.jsp"/>
    	<div class="container">
    		<h2 style="text-align: center;">Resultado do Filtro</h2>
    		<hr>
    		<c:if test="${empty filtro}">
    			<h3 style="text-align: center;">Nenhum resultado para este filtro</h3>
    		</c:if>
    		<div class="col-md-8">
	    		<c:forEach var="f" items="${filtro}">
	    			<div class="row">
	                    <div class="col-md-7">
	                        <img id="foto" src="${f.fotoPerfil}" style="width: 75%">
	                    </div>
	                    <div class="col-md-5" id="dados">
	                        <br><br><br>
	                        <p><strong>Nome:</strong> ${f.nome}</p>
	                        <p><strong>Cidade:</strong> ${f.cidade}</p>
	                        <p><strong>Status:</strong> ${f.status}</p>
	                        <form style="margin-left: 5%" id="formulario" method="POST" action="InformUsu.jsp">
	                            <input name="email" type="hidden" value="${f.email}">
	                            <input style="margin-left: 10%" class="button" type="submit" value="Visualizar Perfil">
	                        </form>
	                    </div>
	                </div>
	    		</c:forEach>
    		</div>
    		<br><br>
    	</div>
    </body>
    <script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</html>