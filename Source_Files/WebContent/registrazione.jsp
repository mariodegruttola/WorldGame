<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="Css/Style.css">
		<link rel="stylesheet" href="Css/Responsive.css">
		<script src="script/validazioni.js"></script>
		<title>Registrazione World Game</title>
	</head>
	<body>
	<section class="conteiner">
		<a href="homePage"><img class="logo" src="Immagini/logo1.jpg"/></a>
		<form name="registration" action="registrazione" method="post" onSubmit="return validaReg();">
			<h1>Crea Account</h1>
			<div class="ins">
				<label>E-mail</label>
				<input class="input" type="text" name="Email" value="" placeholder="xxxxx@xxx.xx" required>
			</div>
			<div class="ins">
				<Label>Password</Label>
				<input class="input" type="text" name="Password" value=""  required>
			</div>
			<div class="ins">
				<label>Codice Fiscale</label>
				<input class="input" type="text" name="CodFisc" value="" required>
			</div>
			<div class="ins">
				<label>Nome</label>
				<input class="input" type="text" name="Nome" value=""  required>	
			</div>
			<div class="ins">
				<label>Cognome</label>
				<input class="input" type="text" name="Cognome" value="" required>
			</div>
			<div class="ins">
				<label>Indirizzo</label>
				<input class="input" type="text" name="Indirizzo" value="" required> 
			</div>
			<div class="ins">
				<label>Numero di telefono</label>
				<input class="input" type="text" name="Telefono" value=""  required>
			</div>
			<div class="ins">
				<label>Città</label>
					<input class="input" type="text" name="Citta" value=""  required>
			</div>
			<div class="ins">
				<label>C.A.P.</label>
				<input class="input" type="text" name="CAP" value=""  required>
			</div>
			<div class="ins">
				<label>Provincia</label>
				<input class="input" type="text" name="Provincia" value=""  required>
			</div>
			<div class="ins">
				<label>Numero Carta di Credito</label>
				<input class="input" type="text" name="NumeroCarta" value=""  required>
			</div>
			<div class="ins">
				<label>Scadenza Carta di Credito</label>
				<input class="input" type="text" name="ScadenzaCarta" value=""  required>
			</div>
			<div class="ins">
				<label>Pin Carta di Credito</label>
				<input class="input" type="text" name="PinCarta" value=""  required>
			</div>
			<div>
				<input class="accedi" type="submit" value="Registrati">
			</div>
			<div>
				<h6>Accedendo dichiari di aver letto e accetti <br>
				integralmente le nostre Condizioni<br>
				generali di uso e vendita, la<br>
				 nostra Informativa sulla privacy.</h6>
			</div>
		</form>
	</section>			

	</body>
</html>