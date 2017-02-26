
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Collection<?> lista = (Collection<?>) request.getAttribute("listaProdotti");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.Prodotto, model.Cliente"%>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
		<title>
			<%if(request.getParameter("categoria") == null){%>
				Ricerca
			<%}else{ %>
				<%=request.getParameter("categoria")%>
			<%}%>		
		</title>
   		<meta name="viewport"  content="initial-scale=1, width=device-width">
  		<link rel="stylesheet" href="Css/Style.css">
 		<link rel="stylesheet" href="Css/Responsive.css"> 
 		<script src="script/jquery.js"></script>
 		<script>
	$(document).ready(function(){
		$(".imgjquery").on({
			mouseenter: function(){
				$(this).css("width", "13em","height","13em");
			},
			mouseleave: function(){
				$(this).css("width", "12em","height","12em");
 			}
		});
	});
	</script>
	</head>
	<body>
		<%@ include file="componenti/header.jsp" %>
		
		<p>
			<h1>Ordina per: 
			<a href="lista?search=<%=request.getParameter("search")%>&categoria=<%=request.getParameter("categoria")%>&tipo=<%=request.getParameter("tipo")%>&pagina=<%=request.getParameter("pagina")%>&ordine=Nome">Nome</a>, 
			<a href="lista?search=<%=request.getParameter("search")%>&categoria=<%=request.getParameter("categoria")%>&tipo=<%=request.getParameter("tipo")%>&pagina=<%=request.getParameter("pagina")%>&ordine=Prezzo">Prezzo</a>, 
			</h1>
		</p>
		<section>
			<div class="bloc" >
				<h4>
					<%
						if(request.getParameter("categoria") == null){
					%>
					<h4>Ricerca</h4>
					<%} else { %>
					<%= request.getParameter("categoria") %>
					<%
						if(!request.getParameter("tipo").equals("null")){
					%>
					- <%= request.getParameter("tipo") %>
					<%}}%>
				</h4>
				<ul class="vetrina">
				<%
					if (lista != null && lista.size() != 0) {
						Iterator<?> it = lista.iterator();
						while (it.hasNext()) {
							Prodotto bean = (Prodotto) it.next();
				%>
					<li>
						<div>
							<a href="paginaProdotto?idArticolo=<%=bean.getIdProdotto() %>" >
							<%
								if(bean.getIdProdotto() <= 90){
							%>
							<img class="imgv imgjquery" src="Immagini/copertineProdotti/<%=bean.getIdProdotto()%>.jpg" >
							<%
								} else {
							%>
							<img class="imgv imgjquery" src="Immagini/copertineProdotti/nonDisp.jpg" >
							<% } %>
							</a>
						</div>
						<div>
							<h3><%=bean.getNome() %></h3>
						</div>	
						<div>
							<span class="prezzo"><span>€ <%= bean.getPrezzo() %></span></span>
						</div>	
					</li>
					<%}} else { %>
					<h2>Prodotto non disponibili</h2>
					<%} %>
				</ul>
			</div> 
  		</section>
  		
  		<form action="lista" method="GET">
  			<input type="hidden" name="categoria" value="<%=request.getParameter("categoria")%>">
 	  		<input type="hidden" name="tipo" value="<%=request.getParameter("tipo")%>">
 	  		<input type="hidden" name="ordine" value="<%=request.getParameter("ordine")%>">
  			<select name="pagina">
  			<%
  				int n = (Integer) request.getAttribute("numPagine");
  				for(int i = 1; i <= n; i++){
  			%>
  			<option value="<%=i%>"><%=i%></option>
  			<%}%>
  			</select>
  			
  			<input class="procedi" type="submit" value="Vai alla pagina">	
  		</form>
  		<footer>
 			<%@ include file="componenti/footer.jsp" %>
  		</footer>
	</body>
</html>