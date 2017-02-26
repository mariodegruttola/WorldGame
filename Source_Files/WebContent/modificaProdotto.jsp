<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Collection<?> products = (Collection<?>) request.getAttribute("listaProdotti");
%>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, model.Prodotto"%>
	<head>
		<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1">
		<title>Modifica prodotti</title>
   		<meta name="viewport"  content="initial-scale=1, width=device-width">
  		<link rel="stylesheet" href="Css/Style.css">
 		<link rel="stylesheet" href="Css/Responsive.css"> 
   		<script src="script/jquery.js"></script>
   		<script src="script/validaProd.js"></script>
 		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</head>
	<body>
	<div class="tabsped">
	<h1><a href="homeAmministratore.html">Torna alla home</a></h1>
	<h1><a href="logout">Logout</a></h1>
		<h2>Modifica Quantità e Prezzo Prodotti</h2>
			<table>
				<tr>
					<th>Nome</th>
					<th>Categoria</th>
					<th>Tipo</th>
					<th>Prezzo</th>
					<th>Quantità</th>
				</tr>
				<%
								if (products != null && products.size() != 0) {
									Iterator<?> it = products.iterator();
									while (it.hasNext()) {
										Prodotto bean = (Prodotto) it.next();
				%>
				<tr>
					<td><%= bean.getNome() %></td>
					<td><%= bean.getCategoria() %></td>
					<td><%= bean.getTipo() %></td>
					
					<form action="modificaProdotto" method="post" onSubmit="return valModProdPrezzo();">
					<input class="input" type="hidden" name="azione" value="updatePrezzo" >	
					<input class="input" type="hidden" name="idProd" value="<%=bean.getIdProdotto() %>" >	
					<td>
						<input type="text" id="upPrezzo" name="Prezzo" value="<%=bean.getPrezzo() %>">
						<input type="submit" value="Aggiorna">
					</td>
					</form>
					
					<form method="post" onSubmit="return valModProdQuantita();">
					<input class="input" type="hidden" name="azione" value="updateQuantita" >
					<input class="input" type="hidden" name="idProd" value="<%=bean.getIdProdotto() %>" >	
					<td>
						<input type="number" id="upQuantita" name="Quantita" min="0" value="<%=bean.getQuantita() %>">
						<input type="submit" value="Aggiorna">
					</td>
				
					</form>
				</tr>
				<%}} %>
			</table>
		</div>
<!--  	<div class="tabsped">
			<h2>Inserisci Prodotto</h2>
			
				<form name="chProd" action="changeProduct" method="post" onSubmit="return valChProd();">
					<input class="input" type="hidden" name="azione" value="inserimentoProd" >	
					<div class="ins">
						<label>Nome</label>
						<input class="input" type="text" name="Nome" required>	
					</div>
					<div class="ins">
						<label>Prezzo</label>
						<input class="input" type="text" name="Prezzo"  required>	
					</div>
					<div class="ins">
						<label>Quantita</label>
						<input class="input" type="text" name="Quantita" required>	
					</div>
					<div class="ins">
						<label>Categoria</label>
						<select name="Categoria">
							<option value="XBOX">XBOX</option>
							<option value="PLAYSTATION">PLAYSTATION</option>
							<option value="NINTENDO">NINTENDO</option>
						</select>	
					</div>
					<div class="ins">
						<label>Tipo</label>
						<select name="Tipo">
							<option value="Accessori">Accessori</option>
							<option value="Videogiochi">Videogiochi</option>
							<option value="Console">Console</option>
						</select>	
					</div>
					<div class="ins">
						<label>Descrizione</label>
						<textarea  class="input" name="Descrizione" maxlength="255" rows="4" required placeholder="enter description"></textarea>	
					</div>
					<div>
						<input class="accedi" type="submit" value="Aggiungi">
					</div>
				</form>
		</div>  -->
	</body>
</html>