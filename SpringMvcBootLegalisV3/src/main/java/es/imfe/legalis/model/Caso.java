package es.imfe.legalis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="casos")
public class Caso {

	private Integer numCaso;
	private Abogado numColegiado;
	private Cliente idCliente;
	private String descripcionCaso;
	private String tipoCaso;
	private Date fechaCaso;
	private String sentencia;
	private Double saldo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getNumCaso() {
		return numCaso;
	}
	public void setNumCaso(Integer numCaso) {
		this.numCaso = numCaso;
	}
	@NotNull
	@ManyToOne
	@JoinColumn(name="numColegiado")
	public Abogado getNumColegiado() {
		return numColegiado;
	}
	public void setNumColegiado(Abogado numColegiado) {
		this.numColegiado = numColegiado;
	}
	@NotNull
	@ManyToOne
	@JoinColumn(name="idCliente")
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	public String getDescripcionCaso() {
		return descripcionCaso;
	}
	public void setDescripcionCaso(String descripcionCaso) {
		this.descripcionCaso = descripcionCaso;
	}
	@NotEmpty
	@Column(name = "tipoCaso", nullable = false, length = 45)	
	public String getTipoCaso() {
		return tipoCaso;
	}
	public void setTipoCaso(String tipoCaso) {
		this.tipoCaso = tipoCaso;
	}
	@NotEmpty
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaCaso", nullable = false)	
	public Date getFechaCaso() {
		return fechaCaso;
	}
	public void setFechaCaso(Date fechaCaso) {
		this.fechaCaso = fechaCaso;
	}
	public String getSentencia() {
		return sentencia;
	}
	public void setSentencia(String sentencia) {
		this.sentencia = sentencia;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}
