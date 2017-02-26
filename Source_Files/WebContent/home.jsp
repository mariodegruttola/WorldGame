
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Collection<Prodotto> products = (Collection<Prodotto>) request.getAttribute("products");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.Prodotto, model.Cliente"%>
<head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
		<title>World Game </title>
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
		<div id="page">  
			<%@ include file="componenti/header.jsp" %>
    		<section> 
    			<div class="bloc">
    				<div class="w3-content w3-section">
  						<img class="mySlides" src="Immagini/1.jpg" >
  						<img class="mySlides" src="Immagini/2.jpg" >
  						<img class="mySlides" src="Immagini/3.jpg" >
  						<img class="mySlides" src="Immagini/4.jpg" >
  						<img class="mySlides" src="Immagini/5.jpg" >
  						<img class="mySlides" src="Immagini/6.jpg" >
					</div>
					<script>
						var myIndex = 0;
						carousel();
						function carousel() {
   							var i;
    						var x = document.getElementsByClassName("mySlides");
    						for (i = 0; i < x.length; i++) {
       							x[i].style.display = "none";  
   							}
    						myIndex++;
    						if (myIndex > x.length) {myIndex = 1}    
    						x[myIndex-1].style.display = "inline";  
   							setTimeout(carousel, 5000);    
						}
					</script>
    			</div>
  			</section>
			
			<section>
				<div class="bloc" >
					<h4>In Vetrina</h4>
					<ul class="vetrina">
							<%
							if (products != null && products.size() != 0) {
								for(Prodotto bean : products){
							/*
								if (products != null && products.size() != 0) {
									List<Prodotto> lista = new ArrayList<Prodotto>();
									lista.addAll(products);
									Random rand = new Random();
									for(int i = 1; i <= 10 && lista.size() != 0; i++){
										int x = rand.nextInt(lista.size());
										Prodotto bean = lista.get(x);
										lista.remove(x);
							*/
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
								<h3><%= bean.getNome()%></h3>
							</div>	
							<div>
								<span class="prezzo">€ <%= bean.getPrezzo()%></span>
							</div>	
						</li>
						<%}} else { %>
						<li>
							<div>
								Prodotti non disponibili!
							</div>	
						</li>
						<% } %>
					</ul>
				</div> 
  			</section>
 		</div>
 		<footer>
 			<%@ include file="componenti/footer.jsp" %>
  		</footer>
	</body>
</html>