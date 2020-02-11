package com.cidenet.hulk.store.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cidenet.hulk.store.enums.EstadoActivoInactivoEnum;

@Entity
@Table(name = "PROVEEDORES")
public class Proveedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_PROVEEDOR", nullable = false, updatable = false)
	private Integer codigoProveedor;
	
	@Column(name = "NIT", nullable = false, length = 20)
	private String nit;
	
	@Column(name = "RAZON_SOCIAL", nullable = false, length = 100)
	private String razonSocial;
	
	@Column(name = "TELEFONO", nullable = true, length = 20)
	private String telefono;
	
	@Column(name = "DIRECCION", nullable = true, length = 100)
	private String direccion;
	
	@Column(name = "CORREO_ELECTRONICO", nullable = true, length = 100)
	private String correoElectronico;
	
	@Column(name = "CONTACTO", nullable = true, length = 40)
	private String contacto;
	
	@Column(name = "TELEFONO_CONTACTO", nullable = true, length = 20)
	private String telefonoContacto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ESTADO_PROVEEDOR", nullable = false, length = 8)
	private EstadoActivoInactivoEnum estadoProveedor;

	public Integer getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(Integer codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public EstadoActivoInactivoEnum getEstadoProveedor() {
		return estadoProveedor;
	}

	public void setEstadoProveedor(EstadoActivoInactivoEnum estadoProveedor) {
		this.estadoProveedor = estadoProveedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoProveedor == null) ? 0 : codigoProveedor.hashCode());
		result = prime * result + ((contacto == null) ? 0 : contacto.hashCode());
		result = prime * result + ((correoElectronico == null) ? 0 : correoElectronico.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((estadoProveedor == null) ? 0 : estadoProveedor.hashCode());
		result = prime * result + ((nit == null) ? 0 : nit.hashCode());
		result = prime * result + ((razonSocial == null) ? 0 : razonSocial.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((telefonoContacto == null) ? 0 : telefonoContacto.hashCode());
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
		Proveedor other = (Proveedor) obj;
		if (codigoProveedor == null) {
			if (other.codigoProveedor != null)
				return false;
		} else if (!codigoProveedor.equals(other.codigoProveedor))
			return false;
		if (contacto == null) {
			if (other.contacto != null)
				return false;
		} else if (!contacto.equals(other.contacto))
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
		if (estadoProveedor != other.estadoProveedor)
			return false;
		if (nit == null) {
			if (other.nit != null)
				return false;
		} else if (!nit.equals(other.nit))
			return false;
		if (razonSocial == null) {
			if (other.razonSocial != null)
				return false;
		} else if (!razonSocial.equals(other.razonSocial))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (telefonoContacto == null) {
			if (other.telefonoContacto != null)
				return false;
		} else if (!telefonoContacto.equals(other.telefonoContacto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Proveedor [codigoProveedor=" + codigoProveedor + ", nit=" + nit + ", razonSocial=" + razonSocial
				+ ", telefono=" + telefono + ", direccion=" + direccion + ", correoElectronico=" + correoElectronico
				+ ", contacto=" + contacto + ", telefonoContacto=" + telefonoContacto + ", estadoProveedor="
				+ estadoProveedor + "]";
	}


}
