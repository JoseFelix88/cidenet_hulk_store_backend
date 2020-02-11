package com.cidenet.hulk.store.ws.ventas.controller;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet.hulk.store.dto.VentaDTO;
import com.cidenet.hulk.store.model.entity.Venta;
import com.cidenet.hulk.store.ws.ventas.service.VentaService;

@RestController
public class VentaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired 
	private VentaService ventaService;
	
	
	@PostMapping(value = "/venta/registrar/")
	public Venta registrarVenta(@RequestBody VentaDTO ventaDto) {
		return ventaService.guardarVenta(ventaDto); 
	}

	@GetMapping("/venta/consultar/{codigoVenta}")
	public Venta consultarVenta(@PathVariable("codigoVenta") Long codigoVenta) {
		Optional<Venta> venta = ventaService.obtenerVentaById(codigoVenta);
		return venta.isPresent() ? venta.get() : null; 
	}
}
