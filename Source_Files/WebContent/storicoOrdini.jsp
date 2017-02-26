
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//	ArrayList<Ordine> listaOrdini = (ArrayList) request.getAttribute("listaOrdini");
	Collection<ProdottoOrdine> listaDettagliProdotti = null;
	listaDettagliProdotti = (Collection) request.getAttribute("listaDettagliProdotti");
	Cliente cliente = (Cliente) request.getSession().getAttribute("utente");
	List<Ordine> listaOrdini = cliente.getListaOrdini();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.ProdottoOrdine, model.Ordine, model.Cliente, model.Spedizione" %>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
		<title>Ordini</title>
   		<meta name="viewport"  content="initial-scale=1, width=device-width">
  		<link rel="stylesheet" href="Css/Style.css">
 		<link rel="stylesheet" href="Css/Responsive.css"> 
	</head>
	<body>
		<div id="page">  
			<%@ include file="componenti/header.jsp" %>
			<div class="divtable">
			 	<h3 class="car">I miei ordini</h3>
				<table style="width:80%">
 					<tr class="tr">
    						<th>N. Spedizione</th>
  						<th>Data Creazione Ordine</th>
  						<th>Data Consegna</th>
    						<th>Numero Carta di Credito</th>
    						<th>Tipo Spedizione</th>
    						<th>Seleziona</th>
  					</tr>
  					<%
  						if(listaOrdini.size() > 0 && listaOrdini != null){
  							for (Ordine ordine : listaOrdini){
  					%>
  					<tr>
    						<th><%= ordine.getIdOrdine()%></th>
  						<th><%= ordine.getData()%></th>
  						<th><%= ordine.getDataConsegna() %></th>
    						<th><%= ordine.getPagamento()%></th>
    						<th><%= ordine.getSpedizione().getNome()%></th>
    						<th><a href="dettagliOrdine?dettagli=<%=ordine.getIdOrdine()%>">dettagli</a></th>
  					</tr>
  					<%}} %>
  				</table>
  				
	<%
		if (listaDettagliProdotti != null && listaDettagliProdotti.size() > 0) {
	%>
			<h2>Dettagli Ordine Selezionato</h2>
				<table>
		<tr class="tr">
			<th>Nome</th>
			<th>Quantita</th>
			<th>Prezzo unitario</th>
			<th>Prezzo totale</th>
		</tr>
	<%
			for(ProdottoOrdine prodO : listaDettagliProdotti){
	%>

		<tr>
			<td><%= prodO.getProdotto().getNome() %></td>
			<td><%=prodO.getQuantitaOrdinata()%></td>
			<td>€ <%=prodO.getPrezzoUnitario()%></td>
			<td>€ <%=prodO.getCostoTotale()%></td>
		</tr>
	<%
		}}
	%>
		</table>
			</div>
			
		</div>	
		<footer>
 			<%@ include file="componenti/footer.jsp" %>
  		</footer>
	</body>
</html>