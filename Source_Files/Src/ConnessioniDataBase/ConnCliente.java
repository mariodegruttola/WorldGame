package connessioniDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
import model.Ordine;

public class ConnCliente {
		
	public synchronized void doSave(Cliente cliente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO cliente (Email, Password, CodFisc, Nome, Cognome, Indirizzo, Telefono, Citta, Cap, Provincia, NumeroCarta, ScadenzaCarta, PinCarta) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, cliente.getEmail());
			preparedStatement.setString(2, cliente.getPassword());
			preparedStatement.setString(3, cliente.getCodFisc());
			preparedStatement.setString(4, cliente.getNome());
			preparedStatement.setString(5, cliente.getCognome());
			preparedStatement.setString(6, cliente.getIndirizzo());
			preparedStatement.setString(7, cliente.getTelefono());
			preparedStatement.setString(8, cliente.getCitta());
			preparedStatement.setString(9, cliente.getCap());
			preparedStatement.setString(10, cliente.getProvincia());
			preparedStatement.setString(11, cliente.getNumeroCarta());
			preparedStatement.setString(12, cliente.getScadenzaCarta());
			preparedStatement.setString(13, cliente.getPinCarta());
			
			preparedStatement.executeUpdate();

//			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
	public synchronized Cliente doLogin(String email, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "SELECT * FROM cliente WHERE Email = ? AND Password = ?";
		Cliente cliente =  null;
		
		ConnOrdine cn = new ConnOrdine();
		
		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()){
				cliente = new Cliente();
				cliente.setEmail(rs.getString("Email"));
				cliente.setPassword(rs.getString("Password"));
				cliente.setCodFisc(rs.getString("CodFisc"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setCognome(rs.getString("Cognome"));
				cliente.setIndirizzo(rs.getString("Indirizzo"));
				cliente.setTelefono(rs.getString("Telefono"));
				cliente.setCitta(rs.getString("Citta"));
				cliente.setCap(rs.getString("Cap"));
				cliente.setProvincia(rs.getString("Provincia"));
				cliente.setNumeroCarta(rs.getString("NumeroCarta"));
				cliente.setScadenzaCarta(rs.getString("ScadenzaCarta"));
				cliente.setPinCarta(rs.getString("PinCarta"));
				
				ArrayList<Ordine> listaOrdini = cn.doRetrieveByUtente(cliente.getEmail());
				cliente.setListaOrdini(listaOrdini);
			}
		} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
						connection.close();
				}
			}
		return cliente;
	}
	public synchronized void doUpdate(Cliente cliente, String em) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE cliente SET Email = ?, Password = ?, CodFisc = ?, Nome = ?, Cognome = ?, Indirizzo = ?, Telefono = ?, Citta = ?, Cap = ?, Provincia = ?, "
				+ "NumeroCarta = ?, ScadenzaCarta = ?, PinCarta = ? WHERE Email = ?";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, cliente.getEmail());
			preparedStatement.setString(2, cliente.getPassword());
			preparedStatement.setString(3, cliente.getCodFisc());
			preparedStatement.setString(4, cliente.getNome());
			preparedStatement.setString(5, cliente.getCognome());
			preparedStatement.setString(6, cliente.getIndirizzo());
			preparedStatement.setString(7, cliente.getTelefono());
			preparedStatement.setString(8, cliente.getCitta());
			preparedStatement.setString(9, cliente.getCap());
			preparedStatement.setString(10, cliente.getProvincia());
			preparedStatement.setString(11, cliente.getNumeroCarta());
			preparedStatement.setString(12, cliente.getScadenzaCarta());
			preparedStatement.setString(13, cliente.getPinCarta());
			preparedStatement.setString(14, em);

			
			preparedStatement.executeUpdate();

//			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
	}
}