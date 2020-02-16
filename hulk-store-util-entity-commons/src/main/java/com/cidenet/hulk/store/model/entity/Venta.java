package com.cidenet.hulk.store.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "VENTAS")
public class Venta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_VENTA", updatable = false)
	private Long codigoVenta;
	
	@Column(name = "FECHA_VENTA", updatable = false)
	private LocalDateTime fechaVenta;
	
	@ManyToOne
	@JoinColumn(name="CODIGO_CLIENTE", foreignKey=@ForeignKey(name="FK_VENTA_CLIENTE"), nullable=false)
	private Cliente cliente;
	
	@Column(name = "TOTAL_VENTA", updatable = false, nullable = false)
	private Integer totalVenta;

	@JsonIgnoreProperties(value = {"venta"})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="venta", cascade=CascadeType.ALL)
	private List<DetalleVenta> lstDetalleVenta;
	
	public Long getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(Long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public LocalDateTime getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDateTime fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(Integer totalVenta) {
		this.totalVenta = totalVenta;
	}

	
	public List<DetalleVenta> getLstDetalleVenta() {
		return lstDetalleVenta;
	}

	public void setLstDetalleVenta(List<DetalleVenta> lstDetalleVenta) {
		this.lstDetalleVenta = lstDetalleVenta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoVenta == null) ? 0 : codigoVenta.hashCode());
		result = prime * result + ((fechaVenta == null) ? 0 : fechaVenta.hashCode());
		result = prime * result + ((totalVenta == null) ? 0 : totalVenta.hashCode());
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
		Venta other = (Venta) obj;
		if (codigoVenta == null) {
			if (other.codigoVenta != null)
				return false;
		} else if (!codigoVenta.equals(other.codigoVenta))
			return false;
		if (fechaVenta == null) {
			if (other.fechaVenta != null)
				return false;
		} else if (!fechaVenta.equals(other.fechaVenta))
			return false;
		if (totalVenta == null) {
			if (other.totalVenta != null)
				return false;
		} else if (!totalVenta.equals(other.totalVenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venta [codigoVenta=" + codigoVenta + ", fechaVenta=" + fechaVenta + ", cliente=" + cliente
				+ ", totalVenta=" + totalVenta + "]";
	}

}
