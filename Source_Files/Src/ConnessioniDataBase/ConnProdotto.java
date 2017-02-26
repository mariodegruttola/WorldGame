package connessioniDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import model.Prodotto;


public class ConnProdotto {

	public synchronized void doSave(Prodotto product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO prodotto (Nome, Prezzo, Quantita, Tipo, Categoria, Descrizione) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getNome());
			preparedStatement.setDouble(2, product.getPrezzo());
			preparedStatement.setInt(3, product.getQuantita());
			preparedStatement.setString(4, product.getTipo());
			preparedStatement.setString(5, product.getCategoria());
			preparedStatement.setString(6, product.getDescrizione());

			preparedStatement.executeUpdate();

//			connection.commit(); Cosa è??
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

	public synchronized void doUpdateQuantita(Prodotto product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE prodotto SET Quantita=? WHERE IdProdotto=?";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, product.getQuantita());
			preparedStatement.setInt(2, product.getIdProdotto());
			preparedStatement.executeUpdate();

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
	
	public synchronized void doUpdatePrezzo(Prodotto product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE prodotto SET Prezzo = ? WHERE IdProdotto=?";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setDouble(1, product.getPrezzo());
			preparedStatement.setInt(2, product.getIdProdotto());
			preparedStatement.executeUpdate();

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

	public synchronized Prodotto doRetrieveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Prodotto bean = new Prodotto();

		String selectSQL = "SELECT * FROM prodotto WHERE IdProdotto = ?";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				bean.setIdProdotto(rs.getInt("IdProdotto"));
				bean.setNome(rs.getString("Nome"));
				bean.setCategoria(rs.getString("Categoria"));
				bean.setPrezzo(rs.getDouble("Prezzo"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setDescrizione(rs.getString("Descrizione"));

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
		return bean;
	}

	public synchronized boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM prodotto WHERE IdProdotto = ?";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}

	public synchronized Collection<Prodotto> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Prodotto> products = new LinkedList<Prodotto>();

		String selectSQL = "SELECT * FROM prodotto";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto bean = new Prodotto();

				bean.setIdProdotto(rs.getInt("IdProdotto"));
				bean.setNome(rs.getString("Nome"));
				bean.setCategoria(rs.getString("Categoria"));
				bean.setPrezzo(rs.getDouble("Prezzo"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setDescrizione(rs.getString("Descrizione"));
				products.add(bean);
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
		return products;
	}
	
	public synchronized ArrayList<Prodotto> doRetrieveByCatAndTipo(String cat, String tipo, String ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Prodotto> products = new ArrayList<Prodotto>();

		String selectSQL = "SELECT * FROM prodotto WHERE Tipo = ? AND Categoria = ?";
		
		if (ordine != null && !ordine.equals("")) {
			selectSQL += " ORDER BY " + ordine;
		}
		
		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, tipo);
			preparedStatement.setString(2, cat);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto bean = new Prodotto();

				bean.setIdProdotto(rs.getInt("IdProdotto"));
				bean.setNome(rs.getString("Nome"));
				bean.setCategoria(rs.getString("Categoria"));
				bean.setPrezzo(rs.getDouble("Prezzo"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setDescrizione(rs.getString("Descrizione"));
				products.add(bean);
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
		return products;
	}
	
	public synchronized ArrayList<Prodotto> doRetrieveByCat(String cat, String ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Prodotto> products = new ArrayList<Prodotto>();

		String selectSQL = "SELECT * FROM prodotto WHERE Categoria = ?";
		
		if (ordine != null && !ordine.equals("")) {
			selectSQL += " ORDER BY " + ordine;
		}
		
		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, cat);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto bean = new Prodotto();

				bean.setIdProdotto(rs.getInt("IdProdotto"));
				bean.setNome(rs.getString("Nome"));
				bean.setCategoria(rs.getString("Categoria"));
				bean.setPrezzo(rs.getDouble("Prezzo"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setDescrizione(rs.getString("Descrizione"));
				products.add(bean);
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
		return products;
	}

	public synchronized ArrayList<Prodotto> doRetrieveForHome() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Prodotto> products = new ArrayList<Prodotto>();

		String selectSQL = "SELECT * FROM prodotto ORDER BY RAND() LIMIT 0,8";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto bean = new Prodotto();

				bean.setIdProdotto(rs.getInt("IdProdotto"));
				bean.setNome(rs.getString("Nome"));
				bean.setCategoria(rs.getString("Categoria"));
				bean.setPrezzo(rs.getDouble("Prezzo"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setTipo(rs.getString("Tipo"));
				bean.setDescrizione(rs.getString("Descrizione"));
				products.add(bean);
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
		return products;
	}
}