<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cliente cliente = (Cliente) request.getSession().getAttribute("utente");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.Cliente"%>
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
		<title>Dati Pagamento </title>
   		<meta name="viewport"  content="initial-scale=1, width=device-width">
  		<link rel="stylesheet" href="Css/Style.css">
 		<link rel="stylesheet" href="Css/Responsive.css">
 		 <script src="script/selection.js"></script>
</head>
	<body>
		<div id="page">  
			<%@ include file="componenti/header.jsp" %>
			
			 	<h3 class="car">Riepilogo:</h3>

				
				<h2>Numero carta di Credito</h2></br>
				<h3><%=cliente.getNumeroCarta() %></h3></br></br>
				
				<h2>Scadenza carta di Credito</h2></br>
				<h3><%=cliente.getScadenzaCarta() %></h3></br></br>
				
				<h2>Pin carta di Credito</h2></br>
				<h3><%=cliente.getPinCarta() %></h3></br></br>
				
			<form action="finalizzaOrdine" method="POST">
   				<div class="proce">
   					<input class="procedi" type="submit" value="Conferma">	
				</div>
			</form>
				
		</div>
		<footer>
 			<%@ include file="componenti/footer.jsp" %>
  		</footer>
</body>
</html>