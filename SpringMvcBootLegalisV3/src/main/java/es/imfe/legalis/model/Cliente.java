package es.imfe.legalis.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="clientes")
public class Cliente {
	
	private Integer idCliente;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String user;
	private String pass;
	private Date fechaAlta;
	private String email;
	private String direccion;
	private String provincia;
	private Double cantidadComision;
	private Double totalComision;
	private String estadoComision;
	private String rango;
	private String nombreReferido;
	private Integer cantidadReferidos;
	
	private Set<Caso> casos; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	@NotEmpty
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@NotEmpty
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	@NotEmpty	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@NotEmpty
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	@NotEmpty	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@NotEmpty	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@NotEmpty
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Double getCantidadComision() {
		return cantidadComision;
	}
	public void setCantidadComision(Double cantidadComision) {
		this.cantidadComision = cantidadComision;
	}
	public Double getTotalComision() {
		return totalComision;
	}
	public void setTotalComision(Double totalComision) {
		this.totalComision = totalComision;
	}
	public String getEstadoComision() {
		return estadoComision;
	}
	public void setEstadoComision(String estadoComision) {
		this.estadoComision = estadoComision;
	}
	public String getRango() {
		return rango;
	}
	public void setRango(String rango) {
		this.rango = rango;
	}
	public String getNombreReferido() {
		return nombreReferido;
	}
	public void setNombreReferido(String nombreReferido) {
		this.nombreReferido = nombreReferido;
	}
	public Integer getCantidadReferidos() {
		return cantidadReferidos;
	}
	public void setCantidadReferidos(Integer cantidadReferidos) {
		this.cantidadReferidos = cantidadReferidos;
	}
	@OneToMany(fetch=FetchType.EAGER, mappedBy="idCliente")
	public Set<Caso> getCasos() {
		return casos;
	}
	public void setCasos(Set<Caso> casos) {
		this.casos = casos;
	}

}