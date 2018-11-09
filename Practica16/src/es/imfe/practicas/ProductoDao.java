package es.imfe.practicas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductoDao {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver" ;
	private static final String URL = "jdbc:mysql://127.0.0.1/inventario";
	private static final String USER = "root";
	private static final String PASS = "root";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, cantidad, precio, comentario, fecha) VALUES (?,?,?,?,?)";
	private static final String SQL_SELECT = "SELECT * FROM productos WHERE nombre LIKE ?";
	private Producto producto;
	
	public void insertar(Producto p) throws ClassNotFoundException, SQLException {
		// 1- Cargar driver
		Class.forName(DRIVER);
		// 2- Conectar con la DB
		Connection conn = DriverManager.getConnection(
				URL , USER, PASS);
		// 3- Obtener el objeto java para operar con la DB
		String sqlInsert = SQL_INSERT ;
		PreparedStatement st = conn.prepareStatement(sqlInsert);
		st.setString(1, p.getNombre());
		st.setInt(2, p.getCantidad());
		st.setDouble(3, p.getPrecio());
		st.setString(4, p.getComentario());
		// Conversion de java.util.date a java.sql.date
		java.util.Date utilDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate= dateFormat.format(utilDate);
		java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
		st.setDate(5, sqlDate);
		// 4- Ejecutamos la Query
		st.executeUpdate();
		// 5- Cerramos el objeto sql
		st.close();
		// 6- Cerramos la conexion
		conn.close();
	}
	
	public List<Producto> listar(String nombre) throws ClassNotFoundException, SQLException{
		List<Producto> lista = new ArrayList<Producto>();
		// 1- Cargar driver
		Class.forName(DRIVER);
		// 2- Conectar con la DB
		Connection conn = DriverManager.getConnection(
						URL , USER, PASS);
		// 3- Obtener el objeto java para operar con la DB
		String sqlSelect = SQL_SELECT;
		PreparedStatement st = conn.prepareStatement(sqlSelect);
		st.setString(1, "%" + nombre + "%");
		// 4- Procesamos los datos con ResultSet
		ResultSet rs = st.executeQuery();
		//st.setString(1, "%nombre%");
		// Iteramos sobre todos los registros
		while (rs.next()) {
			Producto producto1 = new Producto();
			producto1.setId(rs.getInt("id"));
			producto1.setNombre(rs.getString("nombre"));
			producto1.setCantidad(rs.getInt("cantidad"));
			producto1.setPrecio(rs.getDouble("precio"));
			producto1.setComentario(rs.getString("comentario"));
			producto1.setFecha(rs.getDate("fecha"));
			lista.add(producto1);			
		}
		// Cerramos el procesado de resultados
		rs.close();
		st.close();
		conn.close();
		return lista;
	}

}
