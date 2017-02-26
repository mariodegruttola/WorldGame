package connessioniDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Amministratore;

public class ConnAmministratore {
	
	public synchronized Amministratore doLogin(String email, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "SELECT * FROM amministratore WHERE Email = ? AND Password = ?";
		Amministratore amministratore =  null;
		try {
			connection = ConnessioneDB.getConn();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()){
				amministratore = new Amministratore();
				amministratore.setEmail(rs.getString("Email"));
				amministratore.setPassword(rs.getString("Password"));
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
		return amministratore;
	}
}
