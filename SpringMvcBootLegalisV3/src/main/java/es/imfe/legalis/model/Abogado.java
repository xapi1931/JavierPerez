package es.imfe.legalis.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="abogados")
public class Abogado {

	private Integer numColegiado;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String especialidad;
	private String user;
	private String pass;
	private Date fechaAlta;
	private Boolean disponible;
	private String email;
	private String direccion;
	private String provincia;
	private Boolean admin;
	
	private Set<Caso> casos;
	
	@Id
	@NotNull
	public Integer getNumColegiado() {
		return numColegiado;
	}
	public void setNumColegiado(Integer numColegiado) {
		this.numColegiado = numColegiado;
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
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
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
	@NotNull	
	public Boolean getDisponible() {
		return disponible;
	}
	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
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
	@NotNull
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	@OneToMany(fetch=FetchType.EAGER, mappedBy="numColegiado")
	public Set<Caso> getCasos() {
		return casos;
	}
	public void setCasos(Set<Caso> casos) {
		this.casos = casos;
	}
}
