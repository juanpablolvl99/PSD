<%@ page contentType="text/html"%>
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
                    <img id="profile" src="<jsp:getProperty name='dadosUsu' property='fotoPerfil'/>" width="250px" height="250px"/>
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
                    <h1 style="color: black; text-align: center;">Sobre voce !</h1>
                    <br>
                    <p><strong>Nome:</strong><jsp:getProperty name="dadosUsu" property="nome"/></p>
                    <p><strong>Apelido:</strong><jsp:getProperty name="dadosUsu" property="apelido"/></p>
                    <p><strong>Breve Descricao:</strong><jsp:getProperty name="dadosUsu" property="descricao"/></p>
                    <p><strong>Data de Nascimento: </strong><jsp:getProperty name="dadosUsu" property="dataDeNascimento"/></p>
                    <p><strong>Mora em:</strong><jsp:getProperty name="dadosUsu" property="cidade"/></p>
                    <p><strong>Profissao:</strong><jsp:getProperty name="dadosUsu" property="profissao"/></p>
                    <p><strong>Status de Relacionamento:</strong><jsp:getProperty name="dadosUsu" property="status"/></p>
                    <p><strong>Altura:</strong><jsp:getProperty name="dadosUsu" property="altura"/></p>
                    <p><strong>Peso:</strong><jsp:getProperty name="dadosUsu" property="peso"/></p>
                    <p><strong>Cor do Cabelo:</strong><jsp:getProperty name="dadosUsu" property="corDoCabelo"/></p>
                    <p><strong>Principais Passatempos:</strong><jsp:getProperty name="dadosUsu" property="passatempos"/></p>
                    <br>
                </div>
            </div>	
        </div>
        <br>
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
