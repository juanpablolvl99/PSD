<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<title>Galeria</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/navbar.css" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<style>
body,h1,h2,h3,h4,h5,h6,p {background: none !important; font-family: "Karma", sans-serif; color: black !important;}
.w3-bar-block .w3-bar-item {padding:20px}
</style>
<body>

  <jsp:include page="navBar.htm"/>

  <div class="w3-white w3-xlarge" style="max-width:1200px;margin:auto">
	<form action="AdicionarFoto" method="post" enctype="multipart/form-data"> 
		<input type="file" name="foto" class="w3-right w3-button w3-black" style="font-size:18px; left:55px; border-radius:5px"></input>
		<input type="submit" class="w3-right w3-button w3-black" style="font-size:18px; left:55px; border-radius:5px" value="adicionar foto"></input>
	</form>
  </div>

  
<div class="w3-main w3-content w3-padding" style="max-width:1200px;margin-top:100px">

  <div class="w3-row-padding w3-padding-16 w3-center" id="food">
	<c:forEach var="imp" items="${list}">
	<div class="w3-third w3-container w3-margin-bottom">
      <img src="${imp}" alt="Norway" style="width:100%; height:275px" class="w3-hover-opacity">
	</div>  
	</c:forEach>
  </div>
  
  <hr id="about">
  
  <footer class="w3-row-padding w3-padding-32">
    <div class="w3-third">
      <h3>Aqui será registrado suas fotos, e seus momentos.</h3>
	</div>
  
    <div class="w3-third w3-serif">
    </div>
  </footer>

</div>

</body>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</html>