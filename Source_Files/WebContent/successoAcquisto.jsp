<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	Cliente cliente = (Cliente) request.getSession().getAttribute("utente");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.Cliente"%>

	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="Css/Style.css">	
		<title>Successo Acquisto</title>
	</head>
	<body>
		<div>
			<h1 class="successo">
			Grazie <%=cliente.getNome()%> <%=cliente.getCognome() %> per aver acquistato sul nostro sito.
			L'ordine è stato registrato.
			Ti invieremo un'e-mail quando i tuoi articoli saranno spediti.
			</h1>
		</div>
		<div>
			<a class="crea car1" href="homePage">Torna alla Home</a>
		</div>			
	</body>
</html>