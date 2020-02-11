package com.cidenet.hulk.store.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cidenet.hulk.store.enums.EstadoActivoInactivoEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "CLIENTES")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_CLIENTE", nullable = false, updatable = false)
	private Integer codigoCliente;
	
	@Column(name = "NUMERO_IDENTIFICACION", nullable = false, length = 20)
	private String numeroIdentificacion;
	
	@Column(name = "APELLIDOS", nullable = false, length = 45)
	private String apellidos;
	
	@Column(name = "NOMBRES", nullable = false, length = 45)
	private String nombres;
	
	@Column(name = "TELEFONO", nullable = true, length = 20)
	private String telefono;
	
	@Column(name = "DIRECCION", nullable = true, length = 100)
	private String direccion;
	
	@Column(name = "CORREO_ELECTRONICO", nullable = true, length = 100)
	private String correoElectronico;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO_CLIENTE", nullable = false, length = 8)
	private EstadoActivoInactivoEnum estadoCliente;
	
	@JsonIgnoreProperties(value = {"cliente"})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente", cascade=CascadeType.ALL)
	private List<Venta> lstVentasCliente;

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public EstadoActivoInactivoEnum getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(EstadoActivoInactivoEnum estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public List<Venta> getLstVentasCliente() {
		return lstVentasCliente;
	}

	public void setLstVentasCliente(List<Venta> lstVentasCliente) {
		this.lstVentasCliente = lstVentasCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((codigoCliente == null) ? 0 : codigoCliente.hashCode());
		result = prime * result + ((correoElectronico == null) ? 0 : correoElectronico.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((estadoCliente == null) ? 0 : estadoCliente.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		result = prime * result + ((numeroIdentificacion == null) ? 0 : numeroIdentificacion.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (codigoCliente == null) {
			if (other.codigoCliente != null)
				return false;
		} else if (!codigoCliente.equals(other.codigoCliente))
			return false;
		if (correoElectronico == null) {
			if (other.correoElectronico != null)
				return false;
		} else if (!correoElectronico.equals(other.correoElectronico))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (estadoCliente != other.estadoCliente)
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (numeroIdentificacion == null) {
			if (other.numeroIdentificacion != null)
				return false;
		} else if (!numeroIdentificacion.equals(other.numeroIdentificacion))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [codigoCliente=" + codigoCliente + ", numeroIdentificacion=" + numeroIdentificacion
				+ ", apellidos=" + apellidos + ", nombres=" + nombres + ", telefono=" + telefono + ", direccion="
				+ direccion + ", correoElectronico=" + correoElectronico + ", estadoCliente=" + estadoCliente
				+ ", lstVentasCliente=" + lstVentasCliente + "]";
	}

}
