package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestori.GestioneAcquisto;
import model.Spedizione;
import model.Cliente;

@WebServlet("/selezionaSpedizione")
public class SelezionaSpedizioneControl extends HttpServlet {

	public SelezionaSpedizioneControl(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = (Cliente) request.getSession().getAttribute("utente");
		
		if(cliente == null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Errore.html");
			dispatcher.forward(request, response);
		}

		GestioneAcquisto ga = new GestioneAcquisto();
		List<Spedizione> listaSP = null;
		try {
			listaSP = ga.getListaSpedizioni();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String action = request.getParameter("action");
		
		if(action.equals("ship")){
			request.setAttribute("listaSpedizioni", listaSP);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/selezionaSpedizione.jsp");
			dispatcher.forward(request, response);
		}
		if(action.equals("shipAdd")){
			String sped = request.getParameter("sceltaSped");
			for(Spedizione s : listaSP){
				if(s.getNome().equals(sped)){
					request.getSession().setAttribute("spedizione", s);
					break;
				}
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/confermaDatiPagamento.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}