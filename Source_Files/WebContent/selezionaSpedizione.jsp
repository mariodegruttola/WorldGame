<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Collection<?> lista = (Collection<?>) request.getAttribute("listaSpedizioni");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.Spedizione, model.Cliente"%>
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
		<title>Metodo Spedizione </title>
   		<meta name="viewport"  content="initial-scale=1, width=device-width">
  		<link rel="stylesheet" href="Css/Style.css">
 		<link rel="stylesheet" href="Css/Responsive.css">
 		<script src="script/selection.js"></script>
</head>
	<body>
		<div id="page">  
			<%@ include file="componenti/header.jsp" %>
			<div class="divtable">
			 	<h3 class="car">Scegli metodo per la spedizione:</h3>
			 	
			 	<form name="sceltaSp" action="selezionaSpedizione" method="POST" onSubmit="return controlSelSped();">
				<input type="hidden" name="action" value="shipAdd">
			 	<div class="divtable">
			 	<h3 class="car">Tipo Spedizione</h3>
				<table style="width:60%">
 					<tr class="tr">
    						<th>Nome</th>
  						<th>Costo</th>
    						<th>Stima Consegna</th>
    						<th>Seleziona</th>
  					</tr>
  					<%
								if (lista != null && lista.size() != 0) {
									Iterator<?> it = lista.iterator();
									while (it.hasNext()) {
										Spedizione sped = (Spedizione) it.next();
					%>
  					<tr>
  						<td><%=sped.getNome() %></td>
  						<td>€ <%=sped.getCosti() %> </td>
  						<td><%=sped.getStimaConsegna() %>  giorni lavorativi</td>
  						<td><input type="radio" name="sceltaSped" value="<%=sped.getNome() %>"></td>
  					</tr>
  					<%}} %>
   				</table>
   				<div class="proce">
   					<input class="procedi" type="submit" value="Avanti">	
				</div>
			</div>
			</form>
<!-- 		<div class="select">
				
				<select>
				 	<option selected> Seleziona metodo spedizione </option>
				 	<%
								if (lista != null && lista.size() != 0) {
									Iterator<?> it = lista.iterator();
									while (it.hasNext()) {
										Spedizione sped = (Spedizione) it.next();
							%>
 					<option ><%=sped.getNome() %></option>
 					<%}} %>
				</select>
				<h5 class="costo">Costo: €</h5>
				<h5 class="consegna">Consegna stimata: </h5>

				</div>
					<div class="proce">
				<a class="procedi" href="payment.jsp">Procedi</a>
			</div>
			-->
			 </div>	
		
		</div>
		<footer>
 			<%@ include file="componenti/footer.jsp" %>
  		</footer>
</body>
</html>