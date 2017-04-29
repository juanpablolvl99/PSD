<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="m" uri="RetornaMensagens"%>

<m:msgs email="${emailUsuario}"/>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Mensagens</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/search.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">        
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    </head>
    <body>
        <%@include file="NavBar2.jsp"%>
        <div class="container">
            <h3 style="text-align: center; margin-bottom: 3%">Mensagens enviadas para você</h3>
            <div id="separador"></div>
            <div class="row" style="padding: 2% 0% 5% 0%">
                <c:forEach var="msg" items="${mensagens}">
                    <div class="col-md-4" style="margin-top: 3%">
                        <div class="w3-card w3-yellow" style="width: 100%; border-radius: 4px">
                            <header style="padding-top: 1%">
                                <h4 style="margin-left: 2%">De: ${msg.deEmail}</h4>
                            </header>
                            <hr style="margin: 2% 0% 2% 0%">
                            <p style="word-break: break-all; margin: 0% 2% 0% 2%">${msg.mensagem}</p>
                            <hr style="margin: 2% 0% 2% 0%">
                            <footer style="padding: 0% 2% 2% 0%">
                                <form style="width: 100%; margin-bottom: 0" method="post" action="front.do">
                                    <input type="hidden" name="id" value="${msg.id}">
                                    <input class="btn btn-danger" type="submit" name="" value="Excluir" style="margin-left: 71%; width: 30%">
                                    <input type="hidden" name="action" value="ExcluirMensagem">
                                </form>
                            </footer>
                        </div>
                       <form method="post" action="front.do" style="margin-top: 2%">
                            <input class="form-control" type="text" name="mensagem" id="resposta" required="required" style="width: 68%; display: inline-block;">
                            <input type="hidden" name="action" value="Mensagem">
                            <input type="hidden" name="emailDe" value="${emailUsuario}">
                            <input type="hidden" name="emailPara" value="${msg.deEmail}">
                            <input type="hidden" name="pagina" value="Mensagens.jsp">                                       
                            <input type="submit" name="" class="btn btn-primary" value="Responder" style="width: 30%">
                        </form>
                    </div>
                </c:forEach>        
            </div>       
        </div>
    </body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>