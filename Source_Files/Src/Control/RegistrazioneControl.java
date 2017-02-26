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

@WebServlet("/registrazione")
public class RegistrazioneControl extends HttpServlet{
	
	public RegistrazioneControl(){
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		GestioneProfilo ga = new GestioneProfilo();
		String ps = request.getParameter("Password");
		String em = request.getParameter("Email");
		String nm = request.getParameter("Nome");
		String cg = request.getParameter("Cognome");
		String cf = request.getParameter("CodFisc");
		String in = request.getParameter("Indirizzo");
		String tl = request.getParameter("Telefono");
		String ct = request.getParameter("Citta");
		String cp = request.getParameter("CAP");
		String pr = request.getParameter("Provincia");
		String nmC = request.getParameter("NumeroCarta");
		String scC = request.getParameter("ScadenzaCarta");
		String pinC = request.getParameter("PinCarta");
		
		
		try {
			ga.registrazione(ps, em, nm, cg, cf, in, tl, ct, cp, pr, nmC, scC, pinC);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/homePage");
			dispatcher.forward(request, response);
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}