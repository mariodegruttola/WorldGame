<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="Css/Style.css">	
		<title>Successo carrello</title>
	</head>
	<body>
		<div>
			<h1 class="successo"><%=request.getParameter("nomeP")%> è stato aggiunto al tuo carrello.</h1>	
		</div>
		<div>
			<a class="crea car1 provola" href="carrello.jsp">Carrello</a>
			<a class="crea car1" href="homePage">Continua i tuoi acquisti</a>
		</div>			
	</body>
</html>
