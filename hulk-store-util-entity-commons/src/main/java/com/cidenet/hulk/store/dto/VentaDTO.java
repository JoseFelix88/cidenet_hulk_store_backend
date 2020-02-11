package com.cidenet.hulk.store.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;

public class VentaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LocalDate fechaVenta;
	
	private Integer codigoCliente;
	
	private Integer totalVenta;
	
	private DetalleVentaDTO[] listDetalleVenta;

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

	public DetalleVentaDTO[] getListDetalleVenta() {
		return listDetalleVenta;
	}

	public void setListDetalleVenta(DetalleVentaDTO[] listDetalleVenta) {
		this.listDetalleVenta = listDetalleVenta;
	}

	@Override
	public String toString() {
		return "VentaDTO [fechaVenta=" + fechaVenta + ", codigoCliente=" + codigoCliente + ", totalVenta=" + totalVenta
				+ ", listDetalleVenta=" + Arrays.toString(listDetalleVenta) + "]";
	}
	
}
