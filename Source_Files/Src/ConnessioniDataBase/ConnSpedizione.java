package connessioniDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Spedizione;

public class ConnSpedizione {
	
	public synchronized Spedizione doRetrieveByKey(String key) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
				
		String selectSQL = "SELECT * FROM spedizione WHERE Nome = ?";

		Spedizione spedizione = new Spedizione();
		
		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, key);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				
				spedizione.setNome(rs.getString("Nome"));
				spedizione.setCosto(rs.getInt("Costi"));
				spedizione.setStimaConsegna(rs.getInt("Stima_Consegna"));
	
			}

		}  finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		} 
		return spedizione;	
		
	}
	public synchronized void doSave(Spedizione spedizione) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO spedizione (Nome, Costi, Stima_Consegna) "
				+ "VALUES (?, ?, ?)";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, spedizione.getNome());
			preparedStatement.setInt(2, spedizione.getCosti());
			preparedStatement.setInt(3, spedizione.getStimaConsegna());


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
/* prova metodo di sotto
	public synchronized ArrayList<Spedizione> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<Spedizione> lista = new ArrayList<>();
		
		String selectSQL = "SELECT * FROM spedizione";


		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Spedizione bean = new Spedizione();
		
				bean.setNome(rs.getString("Nome"));
				bean.setCosto(rs.getInt("Costi"));
				bean.setStimaConsegna(rs.getInt("Stima_Consegna"));
				
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
	public synchronized ArrayList<Spedizione> doRetrieveAll() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<Spedizione> lista = new ArrayList<>();
		
		String selectSQL = "SELECT * FROM spedizione";


		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Spedizione bean = new Spedizione();
		
				bean.setNome(rs.getString("Nome"));
				bean.setCosto(rs.getInt("Costi"));
				bean.setStimaConsegna(rs.getInt("Stima_Consegna"));
				
				lista.add(bean);
			}

		}  finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			}  finally {
				if (connection != null)
					connection.close();
			}
		} 
		return lista;	
	}
	
/*	
	public synchronized void doUpdateCosti(String nome, int costi) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE spedizione SET Costi = ? WHERE Nome=?";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, costi);
			preparedStatement.setString(2, nome);
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
public synchronized void doUpdateStimaC(String nome, int stima) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE spedizione SET Stima_Consegna = ? WHERE Nome=?";

		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, stima);
			preparedStatement.setString(2, nome);
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
*/
}