<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="Css/Style.css">
		<link rel="stylesheet" href="Css/Responsive.css">
		<script src="script/validazioni.js"></script>
		<title>World Game Accedi</title>
	</head>
	<body>
		<section class="conteiner">
			<a href="homePage"><img class="logo" src="Immagini/logo1.jpg"/></a>
			<form name="log" action="login" method="POST" onSubmit="return validaLog();">
			
				<input type="hidden" name="from" value="${param.from}"> <!-- Trasferimento del URL di provenienza -->			
			
				<h1>Accedi</h1>
				<div class="ins">
					<label>Indirizzo E-mail</label>
					<input class="input" type="text" name="Email" value="" placeholder="xxxxx@xxx.xx" required>
				</div>
				<div class="ins">
					<label>Password</label>
					<input class="input" type="password" name="Password" value=""  required>
				</div>
				<div>
					<input type="radio" name="tipoAccesso" value="cliente" checked="checked">Cliente</input></br></br>
					<input type="radio" name="tipoAccesso" value="amministratore">Amministratore</input></br></br>
					<input class="accedi" type="submit" value="Accedi">
				</div>
				<div>
					<h5>Sei nuovo su World Game?</h5>
				</div>
				<div>
					<a class="crea" href="registrazione.jsp">Crea un nuovo account</a>
				</div>	
			</form>
		</section>
	</body>
</html>