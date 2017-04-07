<%@page contentType="text/html"%>

<style type="text/css">
	*{
	  position: relative;
	  font-family: 'Varela Round';
	  color: white;
	}
	body{
	  background: url('css/img/wallpaper.jpg') center center no-repeat fixed;
	  background-position: center;
	  background-size: cover;
	}
	li{
		margin-left: 40px;
		margin-top: 7px;
	}
	#active{
		background-color: #363636;
		border-radius: 6px;
	}
	#menu{
		background-color: #1C1C1C;
		background-image:linear-gradient(to bottom, transparent 1px, rgba(0,0,0,.1) 1px);
		margin: 20px;
	}
	form {
	    width:300px;
	    margin-left: 670px;
	    margin-top: 11px;
	}
	.search {
	    padding: 8px 15px;
	    background: rgba(55, 55, 55, 0.8);
	    border: 0px solid #dbdbdb;
	    color: #FF6EB4;
	}
	.button {
	    position: relative;
	    padding: 8px 15px;
	    left: -8px;
	    border: 2px solid #FF6EB4;
	    border-radius: 5px;
	    background-color: #DB7093;
	    color: #fafafa;
	}
	.button:hover  {
	    background-color: #fafafa;
	    color: #FF6EB4;
	}
</style>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
<!-- <link rel="stylesheet" href="css/navbar.css"> -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<nav class="navbar navbar-inverse" id="menu">
	<ul class="nav navbar-nav">
		<li id="active">
            <a><i>Thread of Love</i></a>
        </li>
        <li>
            <a href="">User Profile</a>
        </li>
        <li>
            <a href="">Contacts</a>
        </li>
        <form>
	        <input type="text" class="search" placeholder="Busque amigos..." required>
	        <input type="button" class="button" value="Buscar" >
		</form>
    </ul>
</nav>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>