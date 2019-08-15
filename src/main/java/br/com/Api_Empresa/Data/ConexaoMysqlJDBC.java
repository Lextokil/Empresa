package br.com.Api_Empresa.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoMysqlJDBC implements ConexaoJDBC{
	private Connection connection = null;

	private static final String USERNAME = "root";

	// Senha do mysql
	private static final String PASSWORD = "123456";

	// Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
	private static final String DATABASE_URL =  "jdbc:mysql://localhost/exemplojavanot?useTimezone=true&serverTimezone=UTC";

	public ConexaoMysqlJDBC() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver"); 
		this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		this.connection.setAutoCommit(false);		
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void close() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoMysqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void commit() throws SQLException {
		this.connection.commit();
		this.close();
	}

	public void rollback() {
		if (this.connection != null) {
			try {
				this.connection.rollback();
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoMysqlJDBC.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				this.close();
			}
		}
	}

}
