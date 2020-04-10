package com.cidenet.hulk.store.dto;

import java.io.Serializable;

public class DetalleVentaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long codigoProducto;
	
	private Integer cantidadVenta;
	
	private Integer valorUnidad;

	public DetalleVentaDTO() {}

	public DetalleVentaDTO(Long codigoProducto, Integer cantidadVenta, Integer valorUnidad) {
		super();
		this.codigoProducto = codigoProducto;
		this.cantidadVenta = cantidadVenta;
		this.valorUnidad = valorUnidad;
	}

	public Long getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Integer getCantidadVenta() {
		return cantidadVenta;
	}

	public void setCantidadVenta(Integer cantidadVenta) {
		this.cantidadVenta = cantidadVenta;
	}

	public Integer getValorUnidad() {
		return valorUnidad;
	}

	public void setValorUnidad(Integer valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	@Override
	public String toString() {
		return "DetalleVentaDTO [codigoProducto=" + codigoProducto + ", cantidadVenta=" + cantidadVenta
				+ ", valorUnidad=" + valorUnidad + "]";
	}
	
}
