package com.cidenet.hulk.store.dto;

import java.io.Serializable;

public class DetalleCompraDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer codigoProducto;
	
	private Integer cantidadCompra;
	
	private Integer valorUnidad;

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public Integer getCantidadCompra() {
		return cantidadCompra;
	}

	public void setCantidadCompra(Integer cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}

	public Integer getValorUnidad() {
		return valorUnidad;
	}

	public void setValorUnidad(Integer valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	@Override
	public String toString() {
		return "DetalleVentaDTO [codigoProducto=" + codigoProducto + ", cantidadCompra=" + cantidadCompra
				+ ", valorUnidad=" + valorUnidad + "]";
	}
	
}
