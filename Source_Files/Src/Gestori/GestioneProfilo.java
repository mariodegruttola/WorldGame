package gestori;

import java.sql.SQLException;

import connessioniDataBase.ConnAmministratore;
import connessioniDataBase.ConnCliente;
import model.Amministratore;
import model.Cliente;

public class GestioneProfilo {

	public Cliente loginCliente(String email, String password) throws SQLException {
		
		ConnCliente cn = new ConnCliente();
		Cliente cliente = cn.doLogin(email, password);
		return cliente;
	}
	
	public Amministratore loginAmministratore(String email, String password) throws SQLException {
		ConnAmministratore cn = new ConnAmministratore();
		Amministratore amministratore = cn.doLogin(email, password);
		return amministratore;
	}
	
	//em1 è la vecchia email, da ricordare nel caso l'utente l'abbia modificata
	public Cliente modificaProfilo(String em1, String ps, String em, String nm, String cg, String cf, String in, String tl, String ct,
		String cp, String pr, String nmC, String scC, String pinC) throws SQLException {

		Cliente cliente = new Cliente();
		cliente.setPassword(ps);
		cliente.setEmail(em);
		cliente.setNome(nm);
		cliente.setCognome(cg);
		cliente.setCodFisc(cf);
		cliente.setIndirizzo(in);
		cliente.setTelefono(tl);
		cliente.setCitta(ct);
		cliente.setCap(cp);
		cliente.setProvincia(pr);
		cliente.setNumeroCarta(nmC);
		cliente.setScadenzaCarta(scC);
		cliente.setPinCarta(pinC);
		
		ConnCliente cn = new ConnCliente();
		cn.doUpdate(cliente, em);
		
		return cliente;
	}

	public void registrazione(String ps, String em, String nm, String cg, String cf, String in, String tl, String ct,
			String cp, String pr, String nmC, String scC, String pinC) throws SQLException {
		
		Cliente cliente = new Cliente();
		cliente.setPassword(ps);
		cliente.setEmail(em);
		cliente.setNome(nm);
		cliente.setCognome(cg);
		cliente.setCodFisc(cf);
		cliente.setIndirizzo(in);
		cliente.setTelefono(tl);
		cliente.setCitta(ct);
		cliente.setCap(cp);
		cliente.setProvincia(pr);
		cliente.setNumeroCarta(nmC);
		cliente.setScadenzaCarta(scC);
		cliente.setPinCarta(pinC);
		
		ConnCliente cn = new ConnCliente();
		cn.doSave(cliente);
		
	}
}