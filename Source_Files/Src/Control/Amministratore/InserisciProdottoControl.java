package control.amministratore;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestori.GestioneProdotto;

@WebServlet("/inserimentoProdotto")
public class InserisciProdottoControl extends HttpServlet{
		
	@Override
	public void doPost (HttpServletRequest request, HttpServletResponse response){
		
		if(request.getSession().getAttribute("amministratore") == null){
			try {
				response.sendRedirect("login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{

			GestioneProdotto gp = new GestioneProdotto();
			
			String nome = request.getParameter("Nome");
			Double prezzo = Double.parseDouble(request.getParameter("Prezzo"));
			int quantita = Integer.parseInt(request.getParameter("Quantita"));
			String categoria = request.getParameter("Categoria");
			String tipo = request.getParameter("Tipo");
			String descrizione = request.getParameter("Descrizione");
			
			try {
				gp.inserisciProdotto(nome, prezzo, quantita, categoria, tipo, descrizione);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homeAmministratore.html");
				dispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response){
		doPost(request, response);
	}
}