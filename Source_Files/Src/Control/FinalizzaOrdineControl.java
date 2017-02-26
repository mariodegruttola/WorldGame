package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestori.GestioneAcquisto;
import model.Spedizione;
import model.Carrello;
import model.Cliente;

@WebServlet("/finalizzaOrdine")
public class FinalizzaOrdineControl extends HttpServlet {

	public FinalizzaOrdineControl(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Spedizione spedizione = (Spedizione) request.getSession().getAttribute("spedizione");
		Cliente temp = (Cliente) request.getSession().getAttribute("utente");
		Carrello carrello = (Carrello) request.getSession().getAttribute("cart");

		GestioneAcquisto ga = new GestioneAcquisto();
		Cliente cliente = ga.acquista(spedizione, temp, carrello);
		request.getSession().setAttribute("utente", cliente);
		
		request.getSession().removeAttribute("spedizione");
		request.getSession().removeAttribute("cart");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/successoAcquisto.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}