package es.imfe.practicas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		Producto p3 = new Producto();
		Date fecha = new Date();
		List<Producto> lista = new ArrayList<Producto>();
		ProductoDao dao = new ProductoDao();

		p1.setCantidad(2);
		p1.setComentario("primero");
		p1.setFecha(fecha);
		p1.setNombre("pan");
		p1.setPrecio(1.95);
		
		p2.setCantidad(9);
		p2.setComentario("segundo");
		p2.setFecha(fecha);
		p2.setNombre("carne");
		p2.setPrecio(3.56);
		
		p3.setCantidad(3);
		p3.setComentario("tercero");
		p3.setFecha(fecha);
		p3.setNombre("cerveza");
		p3.setPrecio(1.30);
		
		try {
			dao.insertar(p1);
			dao.insertar(p2);
			dao.insertar(p3);
			lista = dao.listar("cerveza");
			System.out.println("INVENTARIO");
			for (Producto p: lista) {
				System.out.println(p);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error Clase no encontrada");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error de SQL");
			e.printStackTrace();
		}
		
		
	}

}
