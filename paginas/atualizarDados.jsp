<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
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
			</div>
			<div class="col-md-6">
			  <input type="text" name="descricao" placeholder="Breve Descrição" class="campo" value="${dadosUsu.descricao}">
			  <select name="status" id="selecionarStatus" value="${dadosUsu.status}">
				<option>Solteiro (a)</option>
				<option>Namorando</option>
				<option>Casado (a)</option>
				<option>Viúvo (a)</option>
				<option>Divorciado (a)</option>
			  </select><br><br>
			  <input type="number" min="0" max="3" step="0.01" name="altura" value="${dadosUsu.altura}" placeholder="Sua Altura" class="campo">
			  <input type="number" min="0" max="200" step="0.1" name="peso" value="${dadosUsu.peso}" placeholder="Seu Peso" class="campo">
			  <input type="text" name="corDoCabelo" value="${dadosUsu.corDoCabelo}" placeholder="Cor do Cabelo" class="campo">
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
  </body>
</html>