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
@Table(name = "DETALLE_VENTAS")
public class DetalleVenta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_DETALLE_VENTA", updatable = false)
	private Long codigoDetalleVenta;

	@JsonIgnoreProperties(value = {"lstDetalleVenta"})
	@ManyToOne
	@JoinColumn(name = "CODIGO_VENTA", foreignKey = @ForeignKey(name = "FK_DETALLE_VENTA"), nullable = false)
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PRODUCTO", foreignKey = @ForeignKey(name = "FK_DETALLE_VENTA_PRODUCTO"), nullable = false)
	private Producto producto;

	@Column(name = "CANTIDAD_VENTA", nullable = false, length = 6)
	private Integer cantidadVenta;

	@Column(name = "VALOR_UNIDAD_VENTA", nullable = false)
	private Integer valorUnidadVenta;

	@Column(name = "VALOR_TOTAL_VENTA", nullable = false)
	private Integer valorTotalVenta;
	
	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDateTime fechaRegistro;

	public Long getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}

	public void setCodigoDetalleVenta(Long codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidadVenta() {
		return cantidadVenta;
	}

	public void setCantidadVenta(Integer cantidadVenta) {
		this.cantidadVenta = cantidadVenta;
	}

	public Integer getValorUnidadVenta() {
		return valorUnidadVenta;
	}

	public void setValorUnidadVenta(Integer valorUnidadVenta) {
		this.valorUnidadVenta = valorUnidadVenta;
	}

	public Integer getValorTotalVenta() {
		return valorTotalVenta;
	}

	public void setValorTotalVenta(Integer valorTotalVenta) {
		this.valorTotalVenta = valorTotalVenta;
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
		result = prime * result + ((cantidadVenta == null) ? 0 : cantidadVenta.hashCode());
		result = prime * result + ((codigoDetalleVenta == null) ? 0 : codigoDetalleVenta.hashCode());
		result = prime * result + ((fechaRegistro == null) ? 0 : fechaRegistro.hashCode());
		result = prime * result + ((valorTotalVenta == null) ? 0 : valorTotalVenta.hashCode());
		result = prime * result + ((valorUnidadVenta == null) ? 0 : valorUnidadVenta.hashCode());
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
		DetalleVenta other = (DetalleVenta) obj;
		if (cantidadVenta == null) {
			if (other.cantidadVenta != null)
				return false;
		} else if (!cantidadVenta.equals(other.cantidadVenta))
			return false;
		if (codigoDetalleVenta == null) {
			if (other.codigoDetalleVenta != null)
				return false;
		} else if (!codigoDetalleVenta.equals(other.codigoDetalleVenta))
			return false;
		if (fechaRegistro == null) {
			if (other.fechaRegistro != null)
				return false;
		} else if (!fechaRegistro.equals(other.fechaRegistro))
			return false;
		if (valorTotalVenta == null) {
			if (other.valorTotalVenta != null)
				return false;
		} else if (!valorTotalVenta.equals(other.valorTotalVenta))
			return false;
		if (valorUnidadVenta == null) {
			if (other.valorUnidadVenta != null)
				return false;
		} else if (!valorUnidadVenta.equals(other.valorUnidadVenta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetalleVenta [codigoDetalleVenta=" + codigoDetalleVenta + ", venta=" + venta + ", producto=" + producto
				+ ", cantidadVenta=" + cantidadVenta + ", valorUnidadVenta=" + valorUnidadVenta + ", valorTotalVenta="
				+ valorTotalVenta + ", fechaRegistro=" + fechaRegistro + "]";
	}

}
