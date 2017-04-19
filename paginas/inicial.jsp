<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="projeto.psd.entidades.Usuario" %>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Profile page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/profile.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
		<!--<style type="text/css">a{text-decoration:none !important}</style>-->
    </head>
    <body>
        <%@include file="navBar.htm"%>
        <!-- Mano, não consigo colocar essa variavel usu em uma declaração <%! %> -->
        <jsp:useBean id="dadosUsu" class="projeto.psd.entidades.Usuario" scope="session"/>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img id="profile" src="${dadosUsu.fotoPerfil}" width="250px" height="250px"/>
                    <div width="" style="display:inline">
                        <a href="#"><h4>Amigos <span class="badge">0</span></h4></a>
                        <a href="#"><h4>Mensagens <span class="badge">0</span></h4></a>
                        <a href="galeria.jsp"><h4>Galeria <span class="badge">0</span></h4></a>
						<h4 data-toggle="modal" data-target="#myModal" style="cursor:pointer;">Apagar Conta</h4>
						<a href="atualizarDados.jsp"><h4 style="cursor:pointer">Atualizar dados</h4></a>
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
		<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
			  <div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Confirme sua senha para apagar esta conta</h4>
			  </div>
			  <form action="front.do" method="post">
				  <div class="modal-body">
					<input type="text" class="form-control" name="senha" placeholder="senha">
					<input type="hidden" name="action" value="ApagarUsu">
				  </div>
				  <div class="modal-footer">
					<input type="submit" class="btn btn-default">				  
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				  </div>
			  </form>
			</div>

		  </div>
		</div>
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
