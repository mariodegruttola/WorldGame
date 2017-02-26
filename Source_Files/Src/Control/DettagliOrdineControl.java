package control;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Ordine;
import model.ProdottoOrdine;
import model.Cliente;

@WebServlet("/dettagliOrdine")
public class DettagliOrdineControl extends HttpServlet{
	
	public DettagliOrdineControl(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		Collection<ProdottoOrdine> listaProdottiOrdinati = null;
		String d = request.getParameter("dettagli");
		List<Ordine> listaOrdini = ((Cliente) request.getSession().getAttribute("utente")).getListaOrdini();
		
		if(d != null){
			int det = Integer.parseInt(d);
			for(Ordine ordine : listaOrdini) {
				if(ordine.getIdOrdine() == det){
					listaProdottiOrdinati = ordine.getListaProdottiOrdine();
					break;
				}
			}
			request.setAttribute("listaDettagliProdotti", listaProdottiOrdinati);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/storicoOrdini.jsp");
		dispatcher.forward(request, response);
	}
}