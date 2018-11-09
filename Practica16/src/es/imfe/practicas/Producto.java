package es.imfe.practicas;

import java.util.Date;

public class Producto {
	
	private int id;
	private String nombre;
	private int cantidad;
	private double precio;
	private String comentario;
	private Date fecha;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + "\n" 
					+ "nombre: " + nombre + "\n" 
					+ "cantidad: " + cantidad + "\n" 
					+ "precio: " + precio+ "\n" 
					+ "comentario: " + comentario + "\n" 
					+ "fecha: " + fecha + "\n";
	}

}
