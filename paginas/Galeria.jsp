<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="projeto.psd.gerenciadores.GerenciadorGaleria"%>
<%@taglib prefix="df" uri="CarregaDF"%>

<html>
    <title>Galeria</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="css/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
    <style>
        body,h1,h2,h3,h4,h5,h6,p {background: url('css/img/wallpaper.jpg') center center no-repeat fixed; font-family: "Karma", sans-serif; 
		color: black !important;}
		.w3-bar-block .w3-bar-item {padding:20px}
		.addFoto{background-color: rgba(0,0,0,0) !important}
    </style>
    <body>
		<df:carregaDF email="${emailUsuario}" retorna="fotos"/>
        <%@include file="NavBar2.jsp"%>

        <div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:50px">

            <div class="w3-row-padding w3-padding-16 w3-center" id="food">
                <c:forEach var="imp" items="${fotos}">
                    <div class="w3-third w3-container w3-margin-bottom">
                        <img src="${imp}" alt="Norway" style="width:100%; height:300px">
                    </div>  
                </c:forEach>
            </div>

            <hr id="about">

            <footer class="w3-row-padding w3-padding-32">
                <div class="w3-third">
                    <h3>Aqui será registrado suas fotos, e seus momentos.</h3>
                </div>

                <div class="w3-third w3-serif">
                </div>
            </footer>

        </div>

    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>