package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connessioniDataBase.ConnProdotto;
import gestori.GestioneAcquisto;
import model.Prodotto;

@WebServlet("/paginaProdotto")
public class InfoProdControl extends HttpServlet {
	
	static ConnProdotto model = new ConnProdotto();
	
	public InfoProdControl(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		GestioneAcquisto ga = new GestioneAcquisto();
		Prodotto prod;
		try {
			prod = ga.infoProdotto(Integer.parseInt(request.getParameter("idArticolo")));
			request.setAttribute("prod", prod);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/informazioniProdotto.jsp");
		dispatcher.forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response);
	}
}