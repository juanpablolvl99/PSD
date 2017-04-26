<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="RetornaAmigos" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="df" uri="CarregaDF"%>

<f:friends email="${emailUsuario}"/>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Profile page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/profile.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
        <style type="text/css">
		.input-file-container {
		  position: relative;
		  width: 225px;
		} 
		.js .input-file-trigger {
		  display: block;
		  padding: 10px 45px;
		  background: #337ab7;
		  color: #fff;
		  font-size: 1em;
		  transition: all .4s;
		  cursor: pointer;
		  border-radius: 5px;
		}
		.js .input-file {
		  position: absolute;
		  top: 0; left: 0;
		  width: 225px;
		  opacity: 0;
		  padding: 14px 0;
		  cursor: pointer;
		}
		.js .input-file:hover + .input-file-trigger,
		.js .input-file:focus + .input-file-trigger,
		.js .input-file-trigger:hover,
		.js .input-file-trigger:focus {
		  background: #204d74;
		  color: #fff;
		}

		.file-return {
		  margin: 0;
		}
		.file-return:not(:empty) {
		  margin: 1em 0;
		}
		.js .file-return {
		  font-style: italic;
		  font-size: .9em;
		  font-weight: bold;
		}
		.js .file-return:not(:empty):before {
		  content: "Selected file: ";
		  font-style: normal;
		  font-weight: normal;
		}
		</style>
    </head>
    <body>
		<df:carregaDF email="${emailUsuario}" retorna="fotos"/>
		<df:carregaDF email="${emailUsuario}" retorna="datas"/>
        <%@include file="NavBar2.jsp"%>
        <div class="container" style="width:97%">
            <div class="row">
                <div class="col-md-3" style="margin-right:-1%">
                    <ul class="list-group" style="margin: 0em">
                        <li class="list-group-item"><img src="${dadosUsu.fotoPerfil}" class="img-thumbnail" width="100%"></li>
                        <div class="panel-group">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <a data-toggle="collapse" href="#collapse1" style="text-decoration:none">Veja as informações</a>
                                </div>
                                <div id="collapse1" class="panel-collapse collapse">
                                    <ul class="list-group">
                                        <li class="list-group-item">Nome - ${dadosUsu.nome}</li>
                                        <li class="list-group-item">Apelido - ${dadosUsu.apelido}</li>
                                        <li class="list-group-item">Breve Descricao - ${dadosUsu.descricao}</li>
                                        <li class="list-group-item">Data de nascimento - ${dadosUsu.dataDeNascimento}</li>
                                        <li class="list-group-item">Mora em - ${dadosUsu.cidade}</li>
                                        <li class="list-group-item">Profissao - ${dadosUsu.profissao}</li>
                                        <li class="list-group-item">Status - ${dadosUsu.status}</li>
                                        <li class="list-group-item">Altura - ${dadosUsu.altura}</li>
                                        <li class="list-group-item">Peso - ${dadosUsu.peso}</li>
                                        <li class="list-group-item">Cor do cabelo - ${dadosUsu.corDoCabelo}</li>
                                        <li class="list-group-item">Passatempos - ${dadosUsu.passatempos}</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </ul>
                </div>
                <div class="col-md-2" style="margin-right: ">
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                            Configurações <img src="css/img/cog.png" width="25px" style="margin-left:5%"/></button>
                        <ul class="dropdown-menu">
                            <li><a data-toggle="modal" data-target="#myModal" style="cursor:pointer;">Apagar conta</a></li>
                            <li><a href="AtualizarDados.jsp">Atualizar dados</a></li>
                        </ul>
                    </div>
                    <div style="margin-top: 6%">
                    	<a href="Amigos.jsp"><button class="btn btn-primary" type="button" 
                    	style="padding: 4% 26% 4% 26%">Amigos</button></a>	
                    </div>
                    <div style="margin-top: 6%">
                    	<button data-toggle="modal" data-target="#mensagemModal" class="btn btn-primary" type="button" style="padding: 4% 8% 4% 8%">Enviar mensagem</button>	
                    </div>
                    <div style="margin-top: 6%">
                    	<button data-toggle="modal" data-target="#recomendarModal" class="btn btn-primary" type="button" style="padding: 4% 4.7% 4% 4.7%">Recomendar amigo</button>	
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
				<div class="col-md-3">
					<form action="front.do" method="post" enctype="multipart/form-data">
					    <div class="input-file-container" style="display:inline-block">  
						    <input class="input-file" id="my-file" name="foto" type="file"/>
						    <label tabindex="0" for="my-file" class="input-file-trigger" style="padding-left:22%">Publique uma foto</label>
					    </div>
						<input type="hidden" name="action" value="AdicionarFoto"/>
						<input type="submit" class="btn btn-primary" value="&#8593;" style="font-size:18px; width:15%"/>
						<p class="file-return"></p>
					</form>
				</div>
            </div>
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Confirme sua senha para apagar esta conta</h4>
                        </div>
                        <form action="front.do" method="post">
                            <div class="modal-body">
                                <input type="text" class="form-control" name="senha" placeholder="senha" required="required">
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
            <div id="mensagemModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Confirme sua senha para apagar esta conta</h4>
                        </div>
                        <form action="front.do" method="post">
                            <div class="modal-body">
                            	<select class="form-control" name="emailPara" style="margin-bottom: 2%">
                            		<c:forEach var="amigo" items="${amigos}">
                            			<option>${amigo.email}</option>
                            		</c:forEach>
                            	</select>
                                <input type="text" class="form-control" name="mensagem" placeholder="mensagem" required="required">
                                <input type="hidden" name="emailDe" value="${emailUsuario}">
                                <input type="hidden" name="action" value="Mensagem">
                                <input type="hidden" name="pagina" value="Inicial.jsp">                                     
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-default">				  
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div id="recomendarModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Confirme sua senha para apagar esta conta</h4>
                        </div>
                        <form action="front.do" method="post">
                            <div class="modal-body">
                                <input type="text" class="form-control" name="senha" placeholder="senha" required="required">
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
		</div>	
    </body>
	<script>
	document.querySelector("html").classList.add('js');
	var fileInput  = document.querySelector( ".input-file" ),  
		button     = document.querySelector( ".input-file-trigger" ),
		the_return = document.querySelector(".file-return");
					  
		button.addEventListener( "keydown", function( event ) {  
			if ( event.keyCode == 13 || event.keyCode == 32 ) {  
				fileInput.focus();  
			}  
		});
		button.addEventListener( "click", function( event ) {
		   fileInput.focus();
		   return false;
		});  
		fileInput.addEventListener( "change", function( event ) {  
			the_return.innerHTML = this.value;  
		});
	</script>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
