<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="projeto.psd.entidades.Usuario"%>
<%@taglib prefix="myTags" uri="VerificaPedido"%>
<%@taglib prefix="cf" uri="CarregaFotos"%> 
<%@taglib prefix="cd" uri="CarregaDatas"%> 

<jsp:useBean id="usuBus" class="projeto.psd.entidades.Usuario" scope="request"/>
<cf:carregaFotos email="${user.email}"></cf:carregaFotos>
<cd:carregaDatas email="${user.email}"></cd:carregaDatas>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Pagina de Busca</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/profile.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    </head>
    <body>
        <%@include file="NavBar2.jsp"%>
        <div class="container" style="width:97%">
        	<div class="row">
	        	<c:if test="${user.email eq emailUsuario}">
	        		<jsp:forward page="Inicial.jsp"/>
	        	</c:if>
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
                                        <c:if test="${cond2}">
                                        <c:if test="${cond3}">
                                        <c:if test="${cond4}">
                                        <li class="list-group-item">
                                            <form id="formulario" method="POST" style="margin-left:15%" action="front.do">
                                                <input type="hidden" name="deUsuario" value="${dadosUsu.email}">
                                                <input type="hidden" name="paraUsuario" value="${user.email}">
                                                <input type="hidden" name="action" value="Convite">
                                                <input class="button" type="submit" value="Mandar Convite">
                                            </form>
                                        </li>
                                        </c:if>
                                        </c:if>
                                        </c:if>
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
                </div>
                
                <div class="col-md-2">
                    <div> 
                        <!--style="padding: 4% 19.2% 4% 19.2%"-->
                        <c:if test="${cond}">
                        <c:if test="${cond2}">
                        <c:if test="${cond3}">
                        <c:if test="${cond4}">
                        <form id="formulario" method="POST" style="margin-left:15%; margin-top: 2%" action="front.do">
                            <input type="hidden" name="deUsuario" value="${dadosUsu.email}">
                            <input type="hidden" name="paraUsuario" value="${user.email}">
                            <input type="hidden" name="action" value="Convite">
                            <input class="btn btn-primary" type="submit" value="Mandar Convite">
                        </form>
                        </c:if>
                        </c:if>
                        </c:if>
                        </c:if>
                    </div>
                </div>
                <div class="col-md-4 main" style="padding: 0em">
                    <ul class="list-group" style="margin: 0em;">
                        <c:forEach var="item" items="${list}" varStatus="status">
                            <li class="list-group-item active">${datas[status.index]}</li>
                            <li class="list-group-item"><img src="${item}" width="100%"/></li>
                        </c:forEach>    
                    </ul>
                </div>
        	</div>
            <!-- <div class="col-md-3">
                
            </div> -->
        </div>
    </body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>