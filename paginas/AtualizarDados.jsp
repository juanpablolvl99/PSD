<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="RetornaAmigos" %>

<f:friends email="${emailUsuario}"/>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Atualizar dados</title>
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link rel="stylesheet" href="css/cadastro.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body class="container">
      <div class="loginCadastro">
        <h1 id="centralizarTexto">Atualize seus dados</h1>
        <form class="formLogin" action="front.do" method="post" enctype="multipart/form-data">
          <div class="col-md-4">
            <h3 id="centralizarTexto">Informe uma nova senha</h3>
            <input type="password" name="senha" value="" placeholder="Senha" class="campo" required="required">
            <h3 id="centralizarTexto">Mude Sua Foto do Perfil</h3>
            <input type="file" name="fotoPerfil" id="uploadImagem" class="input" accept="image/*" required="required">
          </div>
          <div class="col-md-8">
			<h3 id="centralizarTexto">Altere seus Dados pessoais</h3>
			<div class="col-md-6">
		    <input type="text" name="nome" placeholder="Seu nome" class="campo" value="${dadosUsu.nome}">
			  <input type="email" name="email" placeholder="Seu Email" class="campo" value="${dadosUsu.email}">
			  <input type="text" name="cidade" placeholder="Cidade" class="campo" value="${dadosUsu.cidade}">
			  <input type="date" name="dataDeNascimento" placeholder="Data de Nascimento" class="campo" value="${dadosUsu.dataDeNascimento}">
			  <input type="text" name="apelido" placeholder="Apelido" class="campo" value="${dadosUsu.apelido}">
			  <input type="text" name="profissao" placeholder="Profissão" class="campo" value="${dadosUsu.profissao}">
        <input name="status" type="hidden" value="Solteiro" required="required">
			</div>
			<div class="col-md-6">
			  <input type="text" name="descricao" placeholder="Descrição" class="campo" value="${dadosUsu.descricao}">
			  <input type="number" min="0" max="3" step="0.01" name="altura" value="${dadosUsu.altura}" placeholder="Sua Altura" class="campo">
			  <input type="number" min="0" max="200" step="0.1" name="peso" value="${dadosUsu.peso}" placeholder="Seu Peso" class="campo">
			  <br>
			  <select required="required" class="form-control" name="corDoCabelo" style="height: 40px;">
			    <option>Preto</option>
			    <option>Castanho</option>
			    <option>Loiro</option>
			    <option>Platinado</option>
			    <option>Ruivo</option>
			  </select>
			  <br>
			  <input type="text" name="passatempos" value="${dadosUsu.passatempos}" placeholder="Passatempos" class="campo">
		    </div>
			<input type="hidden" name="action" value="Atualizar">
          </div>
          <input type="reset" value="Limpar Campos" class="submit imp" style="margin-left:30%;">
          <input type="submit" name="" value="Atualizar" class="submit imp">
        </form>
        <br><br>
      </div>
      <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <!-- <script type="text/javascript">
        $(document).ready(function(){
          $("#status").click(function(){
            $("#status").mouseleave(function(){
              if(($("#status").val() == "Namorando") || ($("#status").val() == "Casado (a)")){
                $("#relacionado").css("display", "block");
                $("#lb").css("display", "block");
              }else{
                $("#relacionado").css("display", "none");
                $("#lb").css("display", "none");                
              }
            });
          });
        });
      </script> -->
  </body>
</html>
