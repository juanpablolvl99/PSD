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
        <%@include file="NavBar2.jsp"%>
        <div class="container main">
            <h1 id="textoCentral">Resultado da Busca</h1>
            <hr>
            <c:if test="${empty encontrados}">
                <h1 id="textoCentral">Nenhum usuário cadastrado com esse nome</h1>
            </c:if>
            <div class="row">
                <div class="col-md-8">
                    <c:forEach var="busca" items="${encontrados}">
                        <div class="row">
                            <div class="col-md-7">
                                <img id="foto" src="${busca.fotoPerfil}" style="width: 75%">
                            </div>
                            <div class="col-md-5" id="dados">
                                <br><br><br>
                                <p><strong>Nome:</strong> ${busca.nome}</p>
                                <p><strong>Apelido:</strong> ${busca.apelido}</p>
                                <p><strong>Cidade:</strong> ${busca.cidade}</p>
                                <p><strong>Passatempos:</strong> ${busca.passatempos}</p>
                                <form style="margin-left: 5%" id="formulario" method="POST" action="InformUsu.jsp">
                                    <input name="email" type="hidden" value="${busca.email}">
                                    <input style="margin-left: 10%" class="button" type="submit" value="Visualizar Perfil">
                                </form>
                            </div>
                        </div>
                        <div id="separador"></div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
