<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<%
if(request.getSession().getAttribute("amministratore") == null){
	try {
		response.sendRedirect("login.jsp");
	} catch (IOException e) {
		e.printStackTrace();
	}
}
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%@ page contentType="text/html; charset=UTF-8" import="java.io.IOException"%>
<title>Inserimento Prodotto</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="Css/Style.css">
	 <link rel="stylesheet" href="Css/Responsive.css"> 
   	<script src="script/jquery.js"></script>
<!-- 	<script src="script/insertProduct.js"></script>
 	<script src="script/loadProduct.js"></script>
-->  	<script src="script/validaProd.js"></script>
</head>
<body>
<h1><a href="homeAmministratore.html">Torna alla home</a></h1>
		<h1><a href="logout">Logout</a></h1>
<div class="tabsped vistas">		

		<form name="inserimentoProd" action="inserimentoProdotto" method="post"  onSubmit="return valChProd();">
		
			<h2>Inserisci Prodotto</h2>
					<div class="ins">
						<label>Nome</label>
						<input class="input" type="text" name="Nome" value="" required>	
					</div>
					<div class="ins">
						<label>Prezzo</label>
						<input class="input" type="text" name="Prezzo"  value="" required>	
					</div>
					<div class="ins">
						<label>Quantita</label>
						<input class="input" type="text" name="Quantita" value=""  required>	
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
						<textarea  class="input" name="Descrizione" maxlength="255" rows="4" value="" required></textarea>	
					</div>
					<div>
				        <input  class="accedi" type="submit" value="Inserisci">
					</div>
				</form>
</div>
<!--
<div class="tabsped vistas ">

		<h2>Visualizza prodotti</h2>

		<table id="prodTable"></table>

</div>	
-->			
<br/>
</body>
</html>