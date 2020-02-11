package com.cidenet.hulk.store.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "DETALLE_COMPRAS")
public class DetalleCompra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_DETALLE_COMPRA", updatable = false)
	private Long codigoDetalleCompra;

	@JsonIgnoreProperties(value = {"lstDetalleCompra"})
	@ManyToOne
	@JoinColumn(name = "CODIGO_COMPRA", foreignKey = @ForeignKey(name = "FK_DETALLE_COMPRA"), nullable = false)
	private Compra compra;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PRODUCTO", foreignKey = @ForeignKey(name = "FK_DETALLE_COMPRA_PRODUCTO"), nullable = false)
	private Producto producto;

	@Column(name = "CANTIDAD_COMPRA", nullable = false, length = 10)
	private Integer cantidadCompra;

	@Column(name = "COSTO_UNIDAD_COMPRA", nullable = false)
	private Integer costoUnidadCompra;

	@Column(name = "COSTO_TOTAL_COMPRA", nullable = false)
	private Integer costoTotalCompra;
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDateTime fechaRegistro;

	public Long getCodigoDetalleCompra() {
		return codigoDetalleCompra;
	}

	public void setCodigoDetalleCompra(Long codigoDetalleCompra) {
		this.codigoDetalleCompra = codigoDetalleCompra;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidadCompra() {
		return cantidadCompra;
	}

	public void setCantidadCompra(Integer cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}

	public Integer getCostoUnidadCompra() {
		return costoUnidadCompra;
	}

	public void setCostoUnidadCompra(Integer costoUnidadCompra) {
		this.costoUnidadCompra = costoUnidadCompra;
	}

	public Integer getCostoTotalCompra() {
		return costoTotalCompra;
	}

	public void setCostoTotalCompra(Integer costoTotalCompra) {
		this.costoTotalCompra = costoTotalCompra;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidadCompra == null) ? 0 : cantidadCompra.hashCode());
		result = prime * result + ((codigoDetalleCompra == null) ? 0 : codigoDetalleCompra.hashCode());
		result = prime * result + ((compra == null) ? 0 : compra.hashCode());
		result = prime * result + ((costoTotalCompra == null) ? 0 : costoTotalCompra.hashCode());
		result = prime * result + ((costoUnidadCompra == null) ? 0 : costoUnidadCompra.hashCode());
		result = prime * result + ((fechaRegistro == null) ? 0 : fechaRegistro.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
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
		DetalleCompra other = (DetalleCompra) obj;
		if (cantidadCompra == null) {
			if (other.cantidadCompra != null)
				return false;
		} else if (!cantidadCompra.equals(other.cantidadCompra))
			return false;
		if (codigoDetalleCompra == null) {
			if (other.codigoDetalleCompra != null)
				return false;
		} else if (!codigoDetalleCompra.equals(other.codigoDetalleCompra))
			return false;
		if (compra == null) {
			if (other.compra != null)
				return false;
		} else if (!compra.equals(other.compra))
			return false;
		if (costoTotalCompra == null) {
			if (other.costoTotalCompra != null)
				return false;
		} else if (!costoTotalCompra.equals(other.costoTotalCompra))
			return false;
		if (costoUnidadCompra == null) {
			if (other.costoUnidadCompra != null)
				return false;
		} else if (!costoUnidadCompra.equals(other.costoUnidadCompra))
			return false;
		if (fechaRegistro == null) {
			if (other.fechaRegistro != null)
				return false;
		} else if (!fechaRegistro.equals(other.fechaRegistro))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetalleCompra [codigoDetalleCompra=" + codigoDetalleCompra + ", compra=" + compra + ", producto="
				+ producto + ", cantidadCompra=" + cantidadCompra + ", costoUnidadCompra=" + costoUnidadCompra
				+ ", costoTotalCompra=" + costoTotalCompra + ", fechaRegistro=" + fechaRegistro + "]";
	}

}
