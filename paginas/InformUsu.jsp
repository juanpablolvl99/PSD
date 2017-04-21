<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="projeto.psd.entidades.Usuario"%>
<%@taglib prefix="myTags" uri="VerificaPedido"%>

<jsp:useBean id="usuBus" class="projeto.psd.entidades.Usuario" scope="request"/>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Pagina de Busca</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/inform.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    </head>
    <body>
        <%@include file="NavBar.htm"%>
        <!-- <div class="container"> -->
        	<div class="col-md-12">
	        	<c:if test="${user.email eq emailUsuario}">
	        		<jsp:forward page="Inicial.jsp"/>
	        	</c:if>
                <div class="container">
	        	  <h1 id="textoCentral">Informações sobre o usuário</h1>
                  <br>
                </div>
	        	<hr>
                <div class="col-md-3" style="margin-right:-1%">

                    <ul class="list-group" style="margin: 0em">
                        <li class="list-group-item"><img src="${user.fotoPerfil}" class="img-thumbnail" width="100%"></li>
                        <div class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a data-toggle="collapse" href="#collapse1" style="text-decoration:none">Veja as informações</a>
                                </div>
                                <div id="collapse1" class="panel-collapse collapse">
                                    <ul class="list-group">
                                        <myTags:verificaPedido deEmail="${dadosUsu.email}" paraEmail="${user.email}"/>
                                        <c:if test="${cond}">
                                        <li class="list-group-item">
                                            <form id="formulario" method="POST" style="margin-left:15%" action="front.do">
                                                <input type="hidden" name="deUsuario" value="${dadosUsu.email}">
                                                <input type="hidden" name="paraUsuario" value="${user.email}">
                                                <input type="hidden" name="action" value="Convite">
                                                <input class="button" type="submit" value="Mandar Convite">
                                            </form>
                                        </li>
                                        </c:if>
                                        <li class="list-group-item">Nome - ${user.nome}</li>
                                        <li class="list-group-item">Apelido - ${user.apelido}</li>
                                        <li class="list-group-item">Breve Descricao - ${user.descricao}</li>
                                        <li class="list-group-item">Data de nascimento - ${user.dataDeNascimento}</li>
                                        <li class="list-group-item">Mora em - ${user.cidade}</li>
                                        <li class="list-group-item">Profissao - ${user.profissao}</li>
                                        <li class="list-group-item">Status - ${user.status}</li>
                                        <li class="list-group-item">Altura - ${user.altura}</li>
                                        <li class="list-group-item">Peso - ${user.peso}</li>
                                        <li class="list-group-item">Cor do cabelo - ${user.corDoCabelo}</li>
                                        <li class="list-group-item">Passatempos - ${user.passatempos}</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </ul>
                <!-- </div> -->
        		<!-- <div class="col-md-7">
        			<img src="${user.fotoPerfil}" width="400px" height="330px">
        			<br><br><br><br>
        		</div>
        		<div class="col-md-5" id="dados">
        			<p><strong>Nome:</strong> ${user.nome}</p>
                    <p><strong>Data de Nascimento: </strong> ${user.dataDeNascimento}</p>
                    <p><strong>Mora em:</strong> ${user.cidade}</p>
                    <p><strong>Profissao:</strong> ${user.profissao}</p>
                    <p><strong>Status de Relacionamento:</strong> ${user.status}</p>
                    <p><strong>Breve Descricao:</strong> ${user.descricao}</p>
                    <myTags:verificaPedido deEmail="${dadosUsu.email}" paraEmail="${user.email}"/>
                        <c:if test="${cond}">
                            <form id="formulario" method="POST" style="margin-left:25%" action="front.do">
                                <input type="hidden" name="deUsuario" value="${dadosUsu.email}">
                                <input type="hidden" name="paraUsuario" value="${user.email}">
                                <input type="hidden" name="action" value="Convite">
                                <input class="button" type="submit" value="Mandar Convite">
                            </form>
                        </c:if>
        		</div> -->
        	</div>
            <!-- <div class="col-md-3">
                
            </div> -->
        </div>
    </body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>