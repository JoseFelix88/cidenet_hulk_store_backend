/**
 * 
 */
package com.cidenet.hulk.store.model.entity.proxy;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

/**
 * @author Thaliana
 *
 *         1:34:00 a. m. 2020
 */
@Entity
@SqlResultSetMapping(name = "reporteDetalleComprasClienteProxy", 
					entities = @EntityResult(entityClass = ReporteDetalleComprasClienteProxy.class, 
		fields = {
		@FieldResult(name = "consecutivoCompra", column = "CONSECUTIVO_COMPRA"),
		@FieldResult(name = "codigoVenta", column = "CODIGO_VENTA"),
		@FieldResult(name = "fechaVenta", column = "FECHA_VENTA"),
		@FieldResult(name = "descripcionProducto", column = "DESCRIPCION_PRODUCTO"),
		@FieldResult(name = "cantidadComprada", column = "CANTIDAD_COMPRADA"),
		@FieldResult(name = "valorUnidad", column = "VALOR_UNIDAD"),
		@FieldResult(name = "valorTotal", column = "VALOR_TOTAL") }))
public class ReporteDetalleComprasClienteProxy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long consecutivoCompra;

	private Long codigoVenta;

	private LocalDate fechaVenta;

	private String descripcionProducto;

	private Integer cantidadComprada;

	private Integer valorUnidad;

	private Integer valorTotal;

	/**
	 * @return consecutivoCompra
	 */
	public Long getConsecutivoCompra() {
		return consecutivoCompra;
	}

	/**
	 * @param consecutivoCompra 
	 */
	public void setConsecutivoCompra(Long consecutivoCompra) {
		this.consecutivoCompra = consecutivoCompra;
	}

	/**
	 * @return codigoVenta
	 */
	public Long getCodigoVenta() {
		return codigoVenta;
	}

	/**
	 * @param codigoVenta 
	 */
	public void setCodigoVenta(Long codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	/**
	 * @return fechaVenta
	 */
	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * @param fechaVenta
	 */
	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	/**
	 * @return descripcionProducto
	 */
	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	/**
	 * @param descripcionProducto
	 */
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	/**
	 * @return cantidadComprada
	 */
	public Integer getCantidadComprada() {
		return cantidadComprada;
	}

	/**
	 * @param cantidadComprada
	 */
	public void setCantidadComprada(Integer cantidadComprada) {
		this.cantidadComprada = cantidadComprada;
	}

	/**
	 * @return valorUnidad
	 */
	public Integer getValorUnidad() {
		return valorUnidad;
	}

	/**
	 * @param valorUnidad
	 */
	public void setValorUnidad(Integer valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	/**
	 * @return valorTotal
	 */
	public Integer getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal
	 */
	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	/** 
	 * <p>Metodo <b>hashCode</b> encargado de </p>
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidadComprada == null) ? 0 : cantidadComprada.hashCode());
		result = prime * result + ((codigoVenta == null) ? 0 : codigoVenta.hashCode());
		result = prime * result + ((consecutivoCompra == null) ? 0 : consecutivoCompra.hashCode());
		result = prime * result + ((descripcionProducto == null) ? 0 : descripcionProducto.hashCode());
		result = prime * result + ((fechaVenta == null) ? 0 : fechaVenta.hashCode());
		result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
		result = prime * result + ((valorUnidad == null) ? 0 : valorUnidad.hashCode());
		return result;
	}

	/** 
	 * <p>Metodo <b>equals</b> encargado de </p>
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReporteDetalleComprasClienteProxy other = (ReporteDetalleComprasClienteProxy) obj;
		if (cantidadComprada == null) {
			if (other.cantidadComprada != null)
				return false;
		} else if (!cantidadComprada.equals(other.cantidadComprada))
			return false;
		if (codigoVenta == null) {
			if (other.codigoVenta != null)
				return false;
		} else if (!codigoVenta.equals(other.codigoVenta))
			return false;
		if (consecutivoCompra == null) {
			if (other.consecutivoCompra != null)
				return false;
		} else if (!consecutivoCompra.equals(other.consecutivoCompra))
			return false;
		if (descripcionProducto == null) {
			if (other.descripcionProducto != null)
				return false;
		} else if (!descripcionProducto.equals(other.descripcionProducto))
			return false;
		if (fechaVenta == null) {
			if (other.fechaVenta != null)
				return false;
		} else if (!fechaVenta.equals(other.fechaVenta))
			return false;
		if (valorTotal == null) {
			if (other.valorTotal != null)
				return false;
		} else if (!valorTotal.equals(other.valorTotal))
			return false;
		if (valorUnidad == null) {
			if (other.valorUnidad != null)
				return false;
		} else if (!valorUnidad.equals(other.valorUnidad))
			return false;
		return true;
	}

	/** 
	 * <p>Metodo <b>toString</b> encargado de </p>
	 * 
	 */
	@Override
	public String toString() {
		return "ReporteDetalleComprasClienteProxy [consecutivoCompra=" + consecutivoCompra + ", codigoVenta="
				+ codigoVenta + ", fechaVenta=" + fechaVenta + ", descripcionProducto=" + descripcionProducto
				+ ", cantidadComprada=" + cantidadComprada + ", valorUnidad=" + valorUnidad + ", valorTotal="
				+ valorTotal + "]";
	}


}
