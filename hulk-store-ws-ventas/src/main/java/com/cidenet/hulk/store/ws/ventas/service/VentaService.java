package com.cidenet.hulk.store.ws.ventas.service;

import java.util.Optional;

import com.cidenet.hulk.store.dto.VentaDTO;
import com.cidenet.hulk.store.model.entity.Venta;

public interface VentaService {

	Venta guardarVenta(VentaDTO venta);

	Optional<Venta> obtenerVentaById(Long codigoVenta);
}
