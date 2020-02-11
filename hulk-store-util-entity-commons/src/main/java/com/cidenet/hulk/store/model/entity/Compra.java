package com.cidenet.hulk.store.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "COMPRAS")
public class Compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_COMPRA", updatable = false)
	private Long codigoCompra;
	
	@Column(name = "FECHA_COMPRA", updatable = false)
	private LocalDateTime fechaCompra;
	
	@JsonIgnoreProperties(value = {"lstComprasProveedor"})
	@ManyToOne
	@JoinColumn(name="CODIGO_PROVEEDOR", foreignKey=@ForeignKey(name="FK_COMPRA_PROVEEDOR"), nullable=false)
	private Proveedor proveedor;
	
	@Column(name = "TOTAL_COMPRA", updatable = false, nullable = false)
	private Integer totalCompra;
	
	@Column(name = "NUMERO_FACTURA_COMPRA", updatable = false, nullable = true, length = 10)
	private String numeroFacturaCompra;
	
	@Column(name = "FECHA_FACTURA_COMPRA", updatable = false, nullable = true)
	private LocalDate fechaFacturaCompra;

	@JsonIgnoreProperties(value = {"compra"})
	@OneToMany(fetch=FetchType.LAZY, mappedBy="compra", cascade=CascadeType.ALL)
	private List<DetalleCompra> lstDetalleCompra;

	public Long getCodigoCompra() {
		return codigoCompra;
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Integer getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(Integer totalCompra) {
		this.totalCompra = totalCompra;
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

	public List<DetalleCompra> getLstDetalleCompra() {
		return lstDetalleCompra;
	}

	public void setLstDetalleCompra(List<DetalleCompra> lstDetalleCompra) {
		this.lstDetalleCompra = lstDetalleCompra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCompra == null) ? 0 : codigoCompra.hashCode());
		result = prime * result + ((fechaCompra == null) ? 0 : fechaCompra.hashCode());
		result = prime * result + ((fechaFacturaCompra == null) ? 0 : fechaFacturaCompra.hashCode());
		result = prime * result + ((lstDetalleCompra == null) ? 0 : lstDetalleCompra.hashCode());
		result = prime * result + ((numeroFacturaCompra == null) ? 0 : numeroFacturaCompra.hashCode());
		result = prime * result + ((proveedor == null) ? 0 : proveedor.hashCode());
		result = prime * result + ((totalCompra == null) ? 0 : totalCompra.hashCode());
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
		Compra other = (Compra) obj;
		if (codigoCompra == null) {
			if (other.codigoCompra != null)
				return false;
		} else if (!codigoCompra.equals(other.codigoCompra))
			return false;
		if (fechaCompra == null) {
			if (other.fechaCompra != null)
				return false;
		} else if (!fechaCompra.equals(other.fechaCompra))
			return false;
		if (fechaFacturaCompra == null) {
			if (other.fechaFacturaCompra != null)
				return false;
		} else if (!fechaFacturaCompra.equals(other.fechaFacturaCompra))
			return false;
		if (lstDetalleCompra == null) {
			if (other.lstDetalleCompra != null)
				return false;
		} else if (!lstDetalleCompra.equals(other.lstDetalleCompra))
			return false;
		if (numeroFacturaCompra == null) {
			if (other.numeroFacturaCompra != null)
				return false;
		} else if (!numeroFacturaCompra.equals(other.numeroFacturaCompra))
			return false;
		if (proveedor == null) {
			if (other.proveedor != null)
				return false;
		} else if (!proveedor.equals(other.proveedor))
			return false;
		if (totalCompra == null) {
			if (other.totalCompra != null)
				return false;
		} else if (!totalCompra.equals(other.totalCompra))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compra [codigoCompra=" + codigoCompra + ", fechaCompra=" + fechaCompra + ", proveedor=" + proveedor
				+ ", totalCompra=" + totalCompra + ", numeroFacturaCompra=" + numeroFacturaCompra
				+ ", fechaFacturaCompra=" + fechaFacturaCompra + ", lstDetalleCompra=" + lstDetalleCompra + "]";
	}

}
