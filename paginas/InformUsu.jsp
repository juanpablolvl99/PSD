<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="myTags" uri="VerificaPedido"%>
<%@taglib prefix="df" uri="CarregaDF"%>
<%@taglib prefix="myUsu" uri="RetornaUsuEmail"%>
<%@taglib prefix="pd" uri="RetornaPedidoRelacionamento"%>

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
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
                                        <li class="list-group-item">Altura - ${otherUser.altura}</li>
                                        <li class="list-group-item">Peso - ${otherUser.peso}</li>
                                        <li class="list-group-item">Cor do cabelo - ${otherUser.corDoCabelo}</li>
                                        <li class="list-group-item">Passatempos - ${otherUser.passatempos}</li>
                                        <pd:retornaPedido userEmail="${otherUser.email}"/>
                                        <c:choose>
                                            <c:when test="${rlcExist}">
                                                <li class="list-group-item">Status - ${otherUser.status}
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <c:choose>
                                                    <c:when test="${relacionamento.userEmail eq otherUser.email}">
                                                        <myUsu:retornaUsu email="${relacionamento.userParaEmail}"/>
                                                        <li class="list-group-item">
                                                            ${relacionamento.status} com: <a href="InformUsu.jsp?email=${otherUser.email}">${otherUser.nome}</a>
                                                        </li>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <myUsu:retornaUsu email="${relacionamento.userEmail}"/>
                                                        <li class="list-group-item">
                                                            ${relacionamento.status} com: <a href="InformUsu.jsp?email=${otherUser.email}">${otherUser.nome}</a>
                                                        </li>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:otherwise>
                                        </c:choose>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </ul>
                </div>

                <c:if test="${not empty param.email}">
                    <myUsu:retornaUsu email="${param.email}"/>
                </c:if>
                <c:if test="${empty param.email}">
                    <myUsu:retornaUsu email="${param.current}"/>
                </c:if>

                <div class="col-md-2">
                    <div> 
                        <myTags:verificaPedido deEmail="${dadosUsu.email}" paraEmail="${otherUser.email}"/>
                        <!--style="padding: 4% 19.2% 4% 19.2%"-->
                        <c:if test="${condicaoPedido}">
                            <c:if test="${condicaoAmizade}">
                                <form id="formulario" method="POST" style="margin-top: 2%" action="front.do">
                                    <input type="hidden" name="deUsuario" value="${dadosUsu.email}">
                                    <input type="hidden" name="paraUsuario" value="${otherUser.email}">
                                    <input type="hidden" name="action" value="Convite">
                                    <input class="btn btn-primary" type="submit" value="Mandar Convite">
                                </form>
                            </c:if>
                        </c:if>
                        <pd:retornaPedido userEmail="${emailUsuario}"/>
                        <c:if test="${condicaoAmizade == 'false'}">
                            <c:if test="${numPedidosFeitos <= 0}">
                                <c:if test="${rlcExist}">
                                    <button style=" margin-top: 2%" class="btn btn-primary" data-toggle="modal" data-target="#filtrarModal2">Relacionamento</button>
                                    <div id="filtrarModal2" class="modal fade" role="dialog">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    <h4 class="modal-title">Pedido de alteração de relacionamento</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form action="front.do" method="post">                
                                                        <label style="margin-left: 2%">Sua relação com essa pessoa:</label>
                                                        <select required="required" class="form-control" name="status">
                                                            <option>Namorando</option>
                                                            <option>Casado</option>
                                                        </select>
                                                        <input type="hidden" name="userEmail" value="${dadosUsu.email}">
                                                        <input type="hidden" name="userParaEmail" value="${otherUser.email}">
                                                        <input type="hidden" name="action" value="PedidoRelacionamento"><br>
                                                        <input type="submit" class="btn btn-default" value="Mandar Pedido" style="margin-left: 77%">
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </c:if>
                            <c:if test="${not rlcExist}">
                                <form method="post" action="ExcluirRelacionamento">
                                    <input type="hidden" name="user" value="${emailUsuario}">
                                    <input type="hidden" name="other" value="${otherUser.email}">
                                    <input type="submit" class="btn btn-primary" value="Excluir Relacionamento">
                                </form>
                            </c:if>
                            <form id="formulario" method="POST" style="margin-top: 10%" action="front.do">
                                <input type="hidden" name="userEmail" value="${dadosUsu.email}">
                                <input type="hidden" name="amigoEmail" value="${otherUser.email}">
                                <input type="hidden" name="action" value="ExcluirAmigo">
                                <input class="btn btn-primary" type="submit" value="Excluir">
                            </form>  
                        </c:if>                    
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
        </div>
    </body>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>