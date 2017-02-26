package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestori.GestioneAcquisto;
import model.Prodotto;

@WebServlet("/lista")
public class ListaProdControl extends HttpServlet{
	
	public ListaProdControl(){
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String cerca = request.getParameter("search");
		String categoria = request.getParameter("categoria");
		String tipo = request.getParameter("tipo");
		int pagina = Integer.parseInt(request.getParameter("pagina"));
		String ordine = null;
		ordine = request.getParameter("ordine");
		GestioneAcquisto ga = new GestioneAcquisto();
		
		ArrayList<Prodotto> listaProd = null;
		ArrayList<Prodotto> listaFinale = null;

		try {
			
			if(cerca != null && !cerca.equals("null")){
				if(cerca.equals("")){
					response.sendRedirect("Errore.html");
					return;
				}
				
				listaProd = ga.ricercaProdottoChiave(cerca, ordine);
				
				listaFinale = selezionaPagina(listaProd, pagina);
				double n = listaProd.size();
				int numeroPagine = (int) Math.ceil(n / 12.0);
				request.setAttribute("numPagine", numeroPagine);
			}
			
			else {
				listaProd = ga.ricercaProdotto(categoria, tipo, ordine);
				listaFinale = selezionaPagina(listaProd, pagina);
				double n = listaProd.size();
				int numeroPagine = (int) Math.ceil(n / 12.0);
				request.setAttribute("numPagine", numeroPagine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listaProdotti", listaFinale);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listaProdotti.jsp");
		dispatcher.forward(request, response);
	}

	private ArrayList<Prodotto> selezionaPagina(ArrayList<Prodotto> listaProd, int pagina) {
		ArrayList<Prodotto> listaFinale = new ArrayList<Prodotto>();
		for(int i = ((pagina * 12) - 12); i < (pagina * 12); i++){
			if(i >= listaProd.size()) break;
			Prodotto e = listaProd.get(i);
			listaFinale.add(e);
			}
		return listaFinale;
	}
}