package control.amministratore;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestori.GestioneProdotto;
import model.Prodotto;

@WebServlet("/modificaProdotto")
public class ModificaProdottoControl extends HttpServlet{
	
	public ModificaProdottoControl(){
		super();
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response){
		
		if(request.getSession().getAttribute("amministratore") == null){
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{
			GestioneProdotto gp = new GestioneProdotto();
			Collection<Prodotto>  listaProd = null;
			try {
				listaProd = gp.getListaProdotti();
				request.setAttribute("listaProdotti", listaProd);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			String azione = request.getParameter("azione");
			if(azione != null && azione.equals("updatePrezzo")){
				int x = Integer.parseInt(request.getParameter("idProd"));
				for(Prodotto temp : listaProd){
					if(temp.getIdProdotto() == x){
						temp.setPrezzo(Double.parseDouble(request.getParameter("Prezzo")));
						try {
							gp.modificaPrezzoProdotto(temp);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
			if(azione != null && azione.equals("updateQuantita")){
				int x = Integer.parseInt(request.getParameter("idProd"));
				for(Prodotto temp : listaProd){
					if(temp.getIdProdotto() == x){
						temp.setQuantita(Integer.parseInt(request.getParameter("Quantita")));
						try {
							gp.modificaQuantitaProdotto(temp);
						} catch (SQLException e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/modificaProdotto.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	protected void doGet (HttpServletRequest request, HttpServletResponse response){
		doPost(request, response);
	}
}