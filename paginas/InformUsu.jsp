<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="myTags" uri="VerificaPedido"%>
<%@taglib prefix="df" uri="CarregaDF"%>
<%@taglib prefix="myUsu" uri="RetornaUsuEmail"%>

<c:if test="${not empty param.email}">
    <myUsu:retornaUsu email="${param.email}"/>
</c:if>
<c:if test="${empty param.email}">
    <myUsu:retornaUsu email="${param.current}"/>
</c:if>

<df:carregaDF email="${otherUser.email}" retorna="fotos"/>
<df:carregaDF email="${otherUser.email}" retorna="datas"/>

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
	        	<c:if test="${otherUser.email eq emailUsuario}">
	        		<jsp:forward page="Inicial.jsp"/>
	        	</c:if>
                <div class="col-md-3" style="margin-right:-1%">

                    <ul class="list-group" style="margin: 0em">
                        <li class="list-group-item"><img src="${otherUser.fotoPerfil}" class="img-thumbnail" width="100%"></li>
                        <div class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a data-toggle="collapse" href="#collapse1" style="text-decoration:none">Veja as informações</a>
                                </div>
                                <div id="collapse1" class="panel-collapse collapse">
                                    <ul class="list-group">
                                        <li class="list-group-item">Nome - ${otherUser.nome}</li>
                                        <li class="list-group-item">Apelido - ${otherUser.apelido}</li>
                                        <li class="list-group-item">Breve Descricao - ${otherUser.descricao}</li>
                                        <li class="list-group-item">Data de nascimento - ${otherUser.dataDeNascimento}</li>
                                        <li class="list-group-item">Mora em - ${otherUser.cidade}</li>
                                        <li class="list-group-item">Profissao - ${otherUser.profissao}</li>
                                        <li class="list-group-item">Status - ${otherUser.status}</li>
                                        <li class="list-group-item">Altura - ${otherUser.altura}</li>
                                        <li class="list-group-item">Peso - ${otherUser.peso}</li>
                                        <li class="list-group-item">Cor do cabelo - ${otherUser.corDoCabelo}</li>
                                        <li class="list-group-item">Passatempos - ${otherUser.passatempos}</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </ul>
                </div>
                
                <div class="col-md-2">
                    <div> 
                        <myTags:verificaPedido deEmail="${dadosUsu.email}" paraEmail="${otherUser.email}"/>
                        <!--style="padding: 4% 19.2% 4% 19.2%"-->
                        <c:if test="${cond}">
                        <c:if test="${cond2}">
                        <c:if test="${cond3}">
                        <c:if test="${cond4}">
                        <form id="formulario" method="POST" style="margin-left:15%; margin-top: 2%" action="front.do">
                            <input type="hidden" name="deUsuario" value="${dadosUsu.email}">
                            <input type="hidden" name="paraUsuario" value="${otherUser.email}">
                            <input type="hidden" name="action" value="Convite">
                            <input class="btn btn-primary" type="submit" value="Mandar Convite">
                        </form>
                        </c:if>
                        </c:if>
                        </c:if>
                        </c:if>
                        <form id="formulario" method="POST" style="margin-left:15%; margin-top: 2%" action="front.do">
                            <input type="hidden" name="userEmail" value="${dadosUsu.email}">
                            <input type="hidden" name="amigoEmail" value="${otherUser.email}">
                            <input type="hidden" name="action" value="ExcluirAmigo">
                            <input class="btn btn-primary" type="submit" value="Excluir">
                        </form>                        
                    </div>
                </div>
                <div class="col-md-4 main" style="padding: 0em">
                    <ul class="list-group" style="margin: 0em;">
                        <c:forEach var="item" items="${fotos}" varStatus="status">
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