package connessioniDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Prodotto;
import model.ProdottoOrdine;

public class ConnProdottoOrdine {
	

	public synchronized void doSave(int idOrdine, int idProdotto, int quantitaOrdinata, double prezzoUnitario) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO prodottoOrdine (Ordine, Prodotto, Quantita, Prezzo) "
				+ "VALUES (?, ?, ?, ?)";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, idOrdine);
			preparedStatement.setInt(2, idProdotto);
			preparedStatement.setInt(3, quantitaOrdinata);
			preparedStatement.setDouble(4, prezzoUnitario);

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
	
	public synchronized ArrayList<ProdottoOrdine> doProductByIdOrder(int idOrder) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<ProdottoOrdine> lista = new ArrayList<ProdottoOrdine>();
		
		String selectSQL = "SELECT * FROM prodottoOrdine WHERE Ordine = ?";
		
		ConnProdotto cnProd = new ConnProdotto();
		
		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idOrder);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProdottoOrdine prodOrd = new ProdottoOrdine();
		
				Prodotto prod = cnProd.doRetrieveByKey(rs.getInt("Prodotto"));
				prodOrd.setProdotto(prod);
				prodOrd.setQuantitaOrdinata(rs.getInt("Quantita"));
				prodOrd.setPrezzoUnitario(rs.getDouble("Prezzo"));
				
				lista.add(prodOrd);
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
		return lista;
	}
/*
	public synchronized ArrayList<FormatoDa> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<FormatoDa> lista = new ArrayList<>();
		
		String selectSQL = "SELECT * FROM formato_da";


		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				FormatoDa bean = new FormatoDa();
		
				bean.setIdOrdine(rs.getInt("Ordine"));
				bean.setIdProdotto(rs.getInt("Prodotto"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setPrezzo(rs.getDouble("Prezzo"));
				
				lista.add(bean);
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
		return lista;
	}
*/
/*
	public synchronized ArrayList<FormatoDa> doRetrieveByIdOrder(int idOrder) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<FormatoDa> lista = new ArrayList<>();
		
		String selectSQL = "SELECT * FROM formato_da WHERE Ordine = ?";


		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idOrder);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				FormatoDa bean = new FormatoDa();
		
				bean.setIdOrdine(rs.getInt("Ordine"));
				bean.setIdProdotto(rs.getInt("Prodotto"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setPrezzo(rs.getDouble("Prezzo"));
				
				lista.add(bean);
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
		return lista;
	}
*/
/*
	public synchronized ArrayList<ProdottoOrdine> doProductByIdOrder(int idOrder) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<ProdottoOrdine> lista = new ArrayList<>();
		
		String selectSQL = "SELECT prodotto.Nome, 	formato_da.Quantita, formato_da.Prezzo FROM prodotto, formato_da WHERE Ordine = ? AND Prodotto = idProdotto;";


		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idOrder);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProdottoOrdine bean = new ProdottoOrdine();
		
				bean.setNome(rs.getString("Nome"));
				bean.setQuantita(rs.getInt("Quantita"));
				bean.setPrezzo(rs.getDouble("Prezzo"));
				
				lista.add(bean);
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
		return lista;
	}
*/
}