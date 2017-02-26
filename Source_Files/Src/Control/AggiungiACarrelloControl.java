package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestori.GestioneAcquisto;
import model.Carrello;
import model.Prodotto;

@WebServlet("/aggiuntaProdotto")
public class AggiungiACarrelloControl extends HttpServlet {
		
	public AggiungiACarrelloControl(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Carrello carrello = (Carrello)request.getSession().getAttribute("cart");
		if(carrello == null) {
			carrello = new Carrello();
		}
		GestioneAcquisto ga = new GestioneAcquisto();
		Prodotto prod = null;
		try {
			prod = ga.infoProdotto((Integer.parseInt(request.getParameter("idArticolo"))));
			int n = Integer.parseInt(request.getParameter("quantita"));
			carrello.addProdotto(prod, n);
			request.getSession().setAttribute("cart", carrello);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/successoAggiuntaACarrello.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}