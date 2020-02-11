package com.cidenet.hulk.store.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class CompraDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long codigoCompra;
	
	private Integer codigoProveedor;
	
	private LocalDateTime fechaCompra;
	
	private String numeroFacturaCompra;
	
	private LocalDate fechaFacturaCompra;

	private Integer totalCompra;
	
	private DetalleCompraDTO[] listDetalleCompra;

	public Long getCodigoCompra() {
		return codigoCompra;
	}

	public Integer getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(Integer codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public void setCodigoCompra(Long codigoCompra) {
		this.codigoCompra = codigoCompra;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public String getNumeroFacturaCompra() {
		return numeroFacturaCompra;
	}

	public void setNumeroFacturaCompra(String numeroFacturaCompra) {
		this.numeroFacturaCompra = numeroFacturaCompra;
	}

	public LocalDate getFechaFacturaCompra() {
		return fechaFacturaCompra;
	}

	public void setFechaFacturaCompra(LocalDate fechaFacturaCompra) {
		this.fechaFacturaCompra = fechaFacturaCompra;
	}

	public Integer getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(Integer totalCompra) {
		this.totalCompra = totalCompra;
	}

	public DetalleCompraDTO[] getListDetalleCompra() {
		return listDetalleCompra;
	}

	public void setListDetalleCompra(DetalleCompraDTO[] listDetalleCompra) {
		this.listDetalleCompra = listDetalleCompra;
	}

	@Override
	public String toString() {
		return "CompraDTO [codigoCompra=" + codigoCompra + ", codigoProveedor=" + codigoProveedor + ", fechaCompra="
				+ fechaCompra + ", numeroFacturaCompra=" + numeroFacturaCompra + ", fechaFacturaCompra="
				+ fechaFacturaCompra + ", totalCompra=" + totalCompra + ", listDetalleCompra="
				+ Arrays.toString(listDetalleCompra) + "]";
	}
	
	
}
