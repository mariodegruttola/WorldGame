<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<ArticoloOrdinato> lista = new ArrayList<ArticoloOrdinato>();
	Carrello car =(Carrello) request.getSession().getAttribute("cart");
	if(car != null){
		lista = car.getArticoliOrdinati();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.Carrello, model.Cliente, model.ArticoloOrdinato"%>
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
		<title>Carrello </title>
   		<meta name="viewport"  content="initial-scale=1, width=device-width">
  		<link rel="stylesheet" href="Css/Style.css">
 		<link rel="stylesheet" href="Css/Responsive.css"> 
		<script src="script/validaProd.js"></script>
</head>
	<body>
		<div id="page">  
			<%@ include file="componenti/header.jsp" %>
			<div class="divtable">
			 	<h3 class="car">Carrello</h3>
				<table style="width:80%">
 					<tr class="tr">
    						<th>Prodotto</th>
  						<th>Prezzo Unitario</th>
    						<th>Quantità</th>
    						<th>Sub Totale</th>
  					</tr>
  					<% for(ArticoloOrdinato art : lista){ %>
  					<tr>
  						<td><%= art.getNome() %></td>
  						<td>€ <%= art.getPrezzo() %></td>
  						<td>
  						<form name="carrelloQuantita" action="modificaQuantitaArticoloCarrello" method="POST" onSubmit="return valQuantitaProdottoCarrello();">
							<input type="hidden" name="idArticolo" value="<%= art.getIdProdotto()%>">
							<input type="text" name="quantita" value="<%=art.getQuantitaOrdinata()%>">
							<input type="submit" value="Aggiorna">
						</form>
  						</td>
  						<td>€ <%=art.getCostoTotale() %></td>
  					</tr>
  					<%} %>
   				</table>	
			</div>
			<% if (!lista.isEmpty()){ %>
			<div>					
  					 <h4 class="totale">Totale € <%= car.getTotale() %></h4>
  			</div>		
			<div class="proced">
				<%if (utente != null){ %>
				<a class="procedi" href="selezionaSpedizione?action=ship">Procedi</a>
				<%} else{ %>
				<a class="procedi" href="login.jsp?from=${pageContext.request.requestURI}">Procedi</a>
				<%} %>
			</div>
			<% } else{ %>
			<div>					
  					 <h4 class="totale">Totale € 0</h4>
  			</div>
  			<% } %>
		</div>
		<footer>
			<%@ include file="componenti/footer.jsp" %>
		</footer>	
	</body>
</html>