<%@page import="model.Cliente"%>
<nav class="nav">
      			<ul class="topnav">
      				<li class="logo"><a href="homePage"><img class="logo" src="Immagini/logo1.jpg"/></a></li>
        			<li class="icon"><a href="javascript:void(0);" onclick="myFunction()">MENU</a></li>
        			<li class="t dropdown" ><a href="lista?categoria=XBOX&tipo=null&pagina=1">XBOX ONE</a>
        				<div class="dropdown-content">
     						<a href="lista?categoria=XBOX&tipo=Console&pagina=1">Console</a>
      						<a href="lista?categoria=XBOX&tipo=Videogiochi&pagina=1">Videogiochi</a>
      						<a href="lista?categoria=XBOX&tipo=Accessori&pagina=1">Accessori</a>
    					</div>
    				</li>		
        			<li class="t dropdown"><a href="lista?categoria=PLAYSTATION&tipo=null&pagina=1">PLAYSTATION 4</a>
        				<div class="dropdown-content">
     						<a href="lista?categoria=PLAYSTATION&tipo=Console&pagina=1">Console</a>
      						<a href="lista?categoria=PLAYSTATION&tipo=Videogiochi&pagina=1">Videogiochi</a>
      						<a href="lista?categoria=PLAYSTATION&tipo=Accessori&pagina=1">Accessori</a>
    					</div>
        			</li>
        			<li class="t dropdown"><a href="lista?categoria=NINTENDO&tipo=null&pagina=1">NINTENDO</a>
        				<div class="dropdown-content">
     						<a href="lista?categoria=NINTENDO&tipo=Console&pagina=1">Console</a>
      						<a href="lista?categoria=NINTENDO&tipo=Videogiochi&pagina=1">Videogiochi</a>
      						<a href="lista?categoria=NINTENDO&tipo=Accessori&pagina=1">Accessori</a>
    					</div>
        			</li>
        			<li class="t"><a href="#contatti">CONTATTI</a></li>
        			<li class="carrelòlo"><a href="carrello.jsp"><img class="carrello" src="Immagini/carrello.svg"  /></a></li>
        			<%
        			Cliente utente = (Cliente) request.getSession().getAttribute("utente");
					if(utente != null){
				%>
				<li class="utent utente"><a href="logout">Logout</a></li>
				<li class="utente dropdown">Benvenuto <%=utente.getNome()%>!
					<div class="dropdown-content">
     					<a href="modificaProfilo.jsp">Modifica Account</a>
      					<a href="storicoOrdini.jsp">I miei ordini</a>
    				</div>				
				</li>
				
        			<%} else { %>
  	  			<li class="utente"><a href="login.jsp?from=${pageContext.request.requestURI}">Ciao. Accedi</a></li>
     			
        			<%} %>
        		</ul>
        		
    		</nav>
    		<script>
				function myFunction() {
   					 document.getElementsByClassName("topnav")[0].classList.toggle("responsive");
				}
			</script>
			<section>
				<div id="campo-ricerca">
					<div class="container" style="position:relative">
						<form action="lista" method="GET">
						<input type="hidden" name ="pagina" value="1">
    						<div class="form-search">	        
        						<input id="search" type="text" name="search" class="input-text UI-SEARCH UI-NAV-INPUT" placeholder="Inserisci testo" maxlength="128" style="padding-left: 67px;">
								<button type="submit" title="Cerca" class="button search-button"><span><span>Cerca</span></span></button>
    						</div>
						</form>
					</div>
				</div>
			</section>