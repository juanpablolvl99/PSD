<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="projeto.psd.entidades.Usuario" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Profile page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/profile.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    </head>
    <body>
        <%@include file="navBar.htm"%>
        <!-- Mano, não consigo colocar essa variavel usu em uma declaração <%! %> -->
        <jsp:useBean id="dadosUsu" class="projeto.psd.entidades.Usuario" scope="session"/>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img id="profile" src="${dadosUsu.fotoPerfil}" width="250px" height="250px"/>
                    <div width="45%" style="display:inline-block">
                        <a href="#"><h4>Amigos</h4></a>
                        <a href="#"><h4>Mensagens</h4></a>
                        <a href="Galeria.jsp"><h4>Galeria</h4></a>
                    </div>
                    <div style="display:inline-block; margin-left:25%">
                        <p><span class="badge">100</span></p>
                        <p><span class="badge">100</span></p>
                        <p><span class="badge">100</span></p>
                    </div>
                </div>
                <div class="col-md-7">
                    <!-- O UTF-8 não esta funcionando -->
                    <h1 style="color: black; text-align: center;">Sobre você...</h1>
                    <br>
                    <p><strong>Nome: </strong>${dadosUsu.nome}</p>
                    <p><strong>Apelido: </strong>${dadosUsu.apelido}</p>
                    <p><strong>Breve Descricao: </strong>${dadosUsu.descricao}</p>
                    <p><strong>Data de Nascimento: </strong>${dadosUsu.dataDeNascimento}</p>
                    <p><strong>Mora em: </strong>${dadosUsu.cidade}</p>
                    <p><strong>Profissao: </strong>${dadosUsu.profissao}</p>
                    <p><strong>Status de Relacionamento: </strong>${dadosUsu.status}</p>
                    <p><strong>Altura: </strong>${dadosUsu.altura}</p>
                    <p><strong>Peso: </strong>${dadosUsu.peso}</p>
                    <p><strong>Cor do Cabelo: </strong>${dadosUsu.corDoCabelo}</p>
                    <p><strong>Principais Passatempos: </strong>${dadosUsu.passatempos}</p>
                    <br>
                </div>
            </div>	
        </div>
        <br>
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
