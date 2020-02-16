package com.cidenet.hulk.store.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class VentaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LocalDate fechaVenta;
	
	private Integer codigoCliente;
	
	private Integer totalVenta;
	
	private List<DetalleVentaDTO> listDetalleVenta;

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Integer getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(Integer totalVenta) {
		this.totalVenta = totalVenta;
	}


	/**
	 * @return listDetalleVenta
	 */
	public List<DetalleVentaDTO> getListDetalleVenta() {
		return listDetalleVenta;
	}

	/**
	 * @param listDetalleVenta 
	 */
	public void setListDetalleVenta(List<DetalleVentaDTO> listDetalleVenta) {
		this.listDetalleVenta = listDetalleVenta;
	}

	/** 
	 * <p>Metodo <b>toString</b> encargado de imprimir los valores de cada campo.</p>
	 * 
	 */
	@Override
	public String toString() {
		return "VentaDTO [fechaVenta=" + fechaVenta + ", codigoCliente=" + codigoCliente + ", totalVenta=" + totalVenta
				+ ", listDetalleVenta=" + listDetalleVenta + "]";
	}

	
}
