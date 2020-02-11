package com.cidenet.hulk.store.enums;

public enum EstadoActivoInactivoEnum {

	ACTIVO(1, "ACTIVO"),
	INACTIVO(2, "INACTIVO");
	
	private Integer codigo;
	private String nombre;

	

	private EstadoActivoInactivoEnum(Integer codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}



	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public static EstadoActivoInactivoEnum obtenerEnumXNombre(String nombreEstado) {
		for (EstadoActivoInactivoEnum activoInactivo : EstadoActivoInactivoEnum.values()) {
			if(activoInactivo.getNombre().equalsIgnoreCase(nombreEstado)) {
				return activoInactivo;
			}
		}
		return null;
	}

	public static EstadoActivoInactivoEnum obtenerEnumXCodigo(Integer codigoEstado) {
		for (EstadoActivoInactivoEnum activoInactivo : EstadoActivoInactivoEnum.values()) {
			if(activoInactivo.getCodigo().equals(codigoEstado)) {
				return activoInactivo;
			}
		}
		return null;
	}
	
}
