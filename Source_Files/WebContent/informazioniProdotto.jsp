<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		Prodotto product = (Prodotto) request.getAttribute("prod");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.Prodotto, model.Cliente"%>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
		<title>Prodotto</title>
   		<meta name="viewport"  content="initial-scale=1, width=device-width">
  		<link rel="stylesheet" href="Css/Style.css">
 		<link rel="stylesheet" href="Css/Responsive.css"> 
	</head>
	<body>
		<div id="page">  
			<%@ include file="componenti/header.jsp" %>
			<div class="view">
				<div class="immagine im">
					<p class="productimg">
						<%
								if(product.getIdProdotto() <= 90){
							%>
							<img class="imgv imgjquery" src="Immagini/copertineProdotti/<%=product.getIdProdotto()%>.jpg" >
							<%
								} else {
							%>
							<img class="imgv imgjquery" src="Immagini/copertineProdotti/nonDisp.jpg" >
							<% } %>
					</p>
				</div>
				<form action="aggiuntaProdotto" method="POST">
				<div class="productview pv">
					<div class="productname">
						<h1 class="nomeh"><%=product.getNome() %></h1>
					</div>
					<div class="grid">
						<div class="grid1">
							<h4	class="intesth">Tipo</h4>	
							<p><%=product.getTipo() %></p>						
						</div>
						<div class="grid1">
							<h4	class="intesth">Categoria</h4>	
							<p><%=product.getCategoria() %></p>						
						</div>
						<div class="grid1">
							<h4	class="intesth">Prezzo</h4>	
							<p>€ <%= product.getPrezzo() %></p>						
						</div>
						<div class="grid1">
							<h4	class="intesth">Quantita</h4>
							<input type="hidden" name="nomeP" value="<%= product.getNome()%>">
							<input type="hidden" name="idArticolo" value="<%= product.getIdProdotto()%>">
							<%if(product.getQuantita() > 0){ %>
							<input type="number" name="quantita" min="1" max="<%=product.getQuantita()%>" size="2" value="1">
							<%}%>
						</div>
					</div>
					<div><hr></div>
					<div class="grid">
							<%if(product.getQuantita() > 0){ %>
						<div class="grid1">
							<img class="pdisp" src="Immagini/prodottodisp.png" alt="Immagine non disponibile" >
						</div>
						<div class="procedicart">
							<input class="procedi" type="submit" value="Aggiungi al carrello">
						</div>
							<%}else{ %>
							<img class="pdisp" src="Immagini/prodottoarr.png" alt="Immagine non disponibile" >
							<%} %>			
					</div>
					
					<div><hr></div>
					<div>
						<h4 class="descrizione">Descrizione prodotto</h4>
						<p> <%=product.getDescrizione() %></p>
					</div>
				</div>
				</form>
			</div>
		</div>	
		<footer>
 			<%@ include file="componenti/footer.jsp" %>
  		</footer>
	</body>
</html>