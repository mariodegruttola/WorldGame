<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page  import="java.util.*, model.Cliente" %>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="Css/Style.css">
		<link rel="stylesheet" href="Css/Responsive.css">
		<script src="script/validazioni.js"></script>
		<title>Modifica Account</title>
	</head>
	<body>
		<%@ include file="componenti/header.jsp" %>
		<section class="conteiner">
			<img class="logo" src="Immagini/logo1.jpg"/>
			<form name="registration" action="changeData" method="post" onSubmit="return validaReg();">
				<h1>Modifica Account</h1>
				<div class="ins">
					<label>E-mail</label>
					<input class="input" type="text" name="Email" value="<%= utente.getEmail() %>" >
				</div>
				<div class="ins">
					<label>Password</label>
					<input class="input" type="text" name="Password" value="<%= utente.getPassword() %>"  >
				</div>
				<div class="ins">
					<label>Codice Fiscale</label>
					<input class="input" type="text" name="CodFisc" value="<%= utente.getCodFisc() %>" >
				</div>
				<div class="ins">
					<label>Il tuo nome</label>
					<input class="input" type="text" name="Nome" value="<%= utente.getNome() %>" >	
				</div>
				<div class="ins">
					<label>Cognome</label>
					<input class="input" type="text" name="Cognome" value="<%= utente.getCognome() %>">
				</div>
				<div class="ins">
					<label>Indirizzo</label>
					<input class="input" type="text" name="Indirizzo" value="<%= utente.getIndirizzo() %>"> 
				</div>
				<div class="ins">
					<label>Numero di telefono</label>
					<input class="input" type="text" name="Telefono" value="<%= utente.getTelefono() %>"  >
				</div>
				<div class="ins">
					<label>Città</label>
					<input class="input" type="text" name="Citta" value="<%= utente.getCitta() %>" >
				</div>
				<div class="ins">
					<label>C.A.P.</label>
					<input class="input" type="text" name="CAP" value="<%= utente.getCap() %>"  >
				</div>
				<div class="ins">
					<label>Provincia</label>
					<input class="input" type="text" name="Provincia" value="<%= utente.getProvincia() %>">
				</div>
				<div class="ins">
					<label>Numero Carta di Credito</label>
					<input class="input" type="text" name="NumeroCarta" value="<%=utente.getNumeroCarta() %>"  required>
				</div>
				<div class="ins">
					<label>Scadenza Carta di Credito</label>
					<input class="input" type="text" name="ScadenzaCarta" value="<%=utente.getScadenzaCarta() %>"  required>
				</div>
				<div class="ins">
					<label>Pin Carta di Credito</label>
					<input class="input" type="text" name="PinCarta" value="<%=utente.getPinCarta() %>"  required>
				</div>
				<div>
					<input class="accedi" type="submit" value="Salva modifiche">
				</div>
			</form>
		</section>			
	</body>
</html>