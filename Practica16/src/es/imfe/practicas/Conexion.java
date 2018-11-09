package es.imfe.practicas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

	private Connection conn;
	
	// Getters
	public Connection getConn() {
		return conn;
	}

	/**
	 * Carga el driver
	 * @throws ClassNotFoundException 
	 */
	
	public void cargarDriver() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");	
	}
	
	/**
	 * Conectamos con la DB
	 * @throws SQLException 
	 */
	public Connection conectarDB() throws SQLException {
		conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/inventario", "root", "root");
		return conn;
	}
	
	public void cerrar() throws SQLException {
		conn.close();
	}
}
