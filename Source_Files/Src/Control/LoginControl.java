package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gestori.GestioneProfilo;
import model.Amministratore;
import model.Cliente;

@WebServlet("/login")
public class LoginControl extends HttpServlet {
	
	public LoginControl(){
		super();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		try {
			
			GestioneProfilo ga = new GestioneProfilo();
			String email = (String) request.getParameter("Email");
			String password = (String) request.getParameter("Password");
			String tipoAccesso = request.getParameter("tipoAccesso");
			String path = "/Errore.html";
			
			if(tipoAccesso.equals("amministratore")) {
				Amministratore amministratore = ga.loginAmministratore(email, password);
				request.getSession().setAttribute("amministratore", amministratore);
				path = "/homeAmministratore.html";
				System.out.println("email am = " + amministratore.getEmail() + ", pass am = " + amministratore.getPassword());
			}
			else {
				Cliente utente = ga.loginCliente(email, password);
				if(request.getParameter("from").equals("/Progetto/carrello.jsp")){
					path = "/carrello.jsp";
				}
				else{
					path = "/homePage";
				}
				request.getSession().setAttribute("utente", utente);
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Errore.html");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
}