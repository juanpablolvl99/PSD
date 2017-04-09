<%@ page contentType="text/html"%>
<%@ page import="projeto.psd.entidades.Usuario" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Profile page</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/navbar.css" rel="stylesheet">
		<link href="css/profile.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
	</head>
	<body>
		<%@include file="navBar.htm"%>
		<!-- Mano, não consigo colocar essa variavel usu em uma declaração <%! %> -->
		<% Usuario usu = (Usuario) session.getAttribute("dadosUsu"); %>
		<div class="container">
			<div class="col-md-5">
			</div>
			<div class="col-md-7">
			<!-- O UTF-8 não esta funcionando -->
				<h1 style="color: black; text-align: center;">Sobre voce !</h1>
				<br>
				<p><strong>Nome:</strong> <%= usu.getNome() %></p>
				<p><strong>Apelido:</strong> <%= usu.getApelido() %></p>
				<p><strong>Breve Descricao:</strong> <%= usu.getDescricao() %></p>
				<p><strong>Data de Nascimento</strong> <%= usu.getDataDeNascimento() %></p>
				<p><strong>Mora em:</strong> <%= usu.getCidade() %></p>
				<p><strong>Profissao:</strong> <%= usu.getProfissao() %></p>
				<p><strong>Status de Relacionamento:</strong> <%= usu.getStatus() %></p>
				<p><strong>Altura:</strong> <%= usu.getAltura() %></p>
				<p><strong>Peso:</strong> <%= usu.getPeso() %></p>
				<p><strong>Cor do Cabelo:</strong> <%= usu.getCorDoCabelo() %></p>
				<p><strong>Principais Passatempos:</strong> <%= usu.getPassatempos() %></p>
				<br>
			</div>
		</div>
		<br>
	</body>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</html>
