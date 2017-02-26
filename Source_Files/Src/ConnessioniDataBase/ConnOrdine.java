package connessioniDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import model.Ordine;
import model.ProdottoOrdine;

public class ConnOrdine {

	
	public synchronized int doSave(Ordine ordine) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int  id = 0;

		String insertSQL = "INSERT INTO ordine (Data, Cliente, Spedizione, Pagamento) VALUES (?, ?, ?, ?)";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, ordine.getData());
			preparedStatement.setString(2, ordine.getCliente());
			preparedStatement.setString(3, ordine.getSpedizione().getNome());
			preparedStatement.setString(4, ordine.getPagamento());
			preparedStatement.executeUpdate();

			 ResultSet rs = preparedStatement.getGeneratedKeys();
             if(rs.next())
             {
                 id = rs.getInt(1);
             }
             rs.close();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return id;
	}
	
/*	Alternativa per trovare l'id dell'ultimo ordine inserito nel DB
	public synchronized String doMaxId() throws SQLException {
		
		Connection connection = null;
		java.sql.Statement stmnt = null;
		ResultSet rs = null;
		String result = "";
		connection = ConnessioneDB.getConn();
		stmnt = connection.createStatement();
		rs = stmnt.executeQuery("SELECT max(IdOrdine) FROM ecommerce.ordine LIMIT 0, 1");
		if(rs.next()){
				result = rs.getString(1);
			}
		rs.close();
		return result;
	}
*/
	public synchronized ArrayList<Ordine> doRetrieveByUtente(String cliente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Ordine> listaOrdini = new ArrayList<Ordine>();

		String selectSQL = "SELECT * FROM ordine WHERE Cliente = ?";

		ConnProdottoOrdine cn = new ConnProdottoOrdine();
		ConnSpedizione cnS = new ConnSpedizione();
		
		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, cliente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Ordine bean = new Ordine();

				bean.setIdOrdine(rs.getInt("IdOrdine"));
				bean.setData(rs.getString("Data"));
				bean.setUtente(rs.getString("Cliente"));
				bean.setPagamento(rs.getString("Pagamento"));

				bean.setSpedizione(cnS.doRetrieveByKey(rs.getString("Spedizione")));

				ArrayList<ProdottoOrdine> listaProdottiOrdine = cn.doProductByIdOrder(bean.getIdOrdine());
				bean.setListaProdottiOrdine(listaProdottiOrdine);

				listaOrdini.add(bean);
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
		return listaOrdini;
	}
/*	
	public synchronized ArrayList<Ordine> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Ordine> listaOrdini = new ArrayList<Ordine>();

		String selectSQL = "SELECT * FROM ordine";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Ordine bean = new Ordine();

				bean.setIdOrdine(rs.getInt("IdOrdine"));
				bean.setData(rs.getString("Data"));
				bean.setUtente(rs.getString("Utente"));
				bean.setSpedizione(rs.getString("Spedizione"));
				bean.setPagamento(rs.getString("Pagamento"));
				listaOrdini.add(bean);
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
		return listaOrdini;
	}
*/
	public Ordine doRetrieveByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Ordine ordine = new Ordine();

		String selectSQL = "SELECT * FROM ordine WHERE IdOrdine = ?";
		
		ConnProdottoOrdine cn = new ConnProdottoOrdine();
		ConnSpedizione cnS = new ConnSpedizione();

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				ordine.setIdOrdine(rs.getInt("IdOrdine"));
				ordine.setData(rs.getString("Data"));
				ordine.setUtente(rs.getString("Cliente"));
				ordine.setPagamento(rs.getString("Pagamento"));

				ordine.setSpedizione(cnS.doRetrieveByKey(rs.getString("Spedizione")));

				ArrayList<ProdottoOrdine> listaProdottiOrdine = cn.doProductByIdOrder(ordine.getIdOrdine());
				ordine.setListaProdottiOrdine(listaProdottiOrdine);
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
		return ordine;
	}
}