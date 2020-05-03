package com.cidenet.hulk.store.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_PRODUCTO", updatable = false)
	private Long codigoProducto;
	
	@Column(name="CODIGO_BARRAS", nullable = true, length = 20, unique = true)
	private String codigoBarras;
	
	@Column(name="DESCRIPCION", nullable = false, length = 100)
	private String descripcion;
	
	@Column(name = "STOCK_ACTUAL", nullable = false, length = 6)
	private Integer stockActual;
	
	@Column(name = "COSTO_UNITARIO", nullable = false)
	private Integer costoUnitario;
	
	@Column(name = "PRECIO_VENTA", nullable = false)
	private Integer precioVenta;
	
	@Column(name = "VALOR_UTILIDAD", nullable = true)
	private Integer valorUtilidad;
	
	
	@Column(name = "FECHA_ACTUALIZACION", nullable = true)
	private LocalDateTime fechaActualizacion;

	@Column(name = "FECHA_REGISTRO", nullable = false)
	private LocalDateTime fechaRegistro;
	
	public Long getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStockActual() {
		return stockActual;
	}

	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}

	public Integer getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(Integer costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public Integer getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Integer precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Integer getValorUtilidad() {
		return valorUtilidad;
	}

	public void setValorUtilidad(Integer valorUtilidad) {
		this.valorUtilidad = valorUtilidad;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
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
		result = prime * result + ((codigoBarras == null) ? 0 : codigoBarras.hashCode());
		result = prime * result + ((codigoProducto == null) ? 0 : codigoProducto.hashCode());
		result = prime * result + ((costoUnitario == null) ? 0 : costoUnitario.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fechaActualizacion == null) ? 0 : fechaActualizacion.hashCode());
		result = prime * result + ((fechaRegistro == null) ? 0 : fechaRegistro.hashCode());
		result = prime * result + ((precioVenta == null) ? 0 : precioVenta.hashCode());
		result = prime * result + ((stockActual == null) ? 0 : stockActual.hashCode());
		result = prime * result + ((valorUtilidad == null) ? 0 : valorUtilidad.hashCode());
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
		Producto other = (Producto) obj;
		if (codigoBarras == null) {
			if (other.codigoBarras != null)
				return false;
		} else if (!codigoBarras.equals(other.codigoBarras))
			return false;
		if (codigoProducto == null) {
			if (other.codigoProducto != null)
				return false;
		} else if (!codigoProducto.equals(other.codigoProducto))
			return false;
		if (costoUnitario == null) {
			if (other.costoUnitario != null)
				return false;
		} else if (!costoUnitario.equals(other.costoUnitario))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fechaActualizacion == null) {
			if (other.fechaActualizacion != null)
				return false;
		} else if (!fechaActualizacion.equals(other.fechaActualizacion))
			return false;
		if (fechaRegistro == null) {
			if (other.fechaRegistro != null)
				return false;
		} else if (!fechaRegistro.equals(other.fechaRegistro))
			return false;
		if (precioVenta == null) {
			if (other.precioVenta != null)
				return false;
		} else if (!precioVenta.equals(other.precioVenta))
			return false;
		if (stockActual == null) {
			if (other.stockActual != null)
				return false;
		} else if (!stockActual.equals(other.stockActual))
			return false;
		if (valorUtilidad == null) {
			if (other.valorUtilidad != null)
				return false;
		} else if (!valorUtilidad.equals(other.valorUtilidad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", codigoBarras=" + codigoBarras + ", descripcion="
				+ descripcion + ", stockActual=" + stockActual + ", costoUnitario=" + costoUnitario + ", precioVenta="
				+ precioVenta + ", valorUtilidad=" + valorUtilidad + ", fechaActualizacion=" + fechaActualizacion
				+ ", fechaRegistro=" + fechaRegistro + "]";
	}

}
