package com.cidenet.hulk.store.ws.compras.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet.hulk.store.dto.CompraDTO;
import com.cidenet.hulk.store.model.entity.Compra;
import com.cidenet.hulk.store.ws.compras.service.CompraService;

@RestController
public class CompraController {

	@Autowired 
	private CompraService compraService;
	
	@PostMapping("/compra/registrar")
	public Compra registrarCompra(@RequestBody CompraDTO compraDto) {
		return compraService.guardarCompra(compraDto);
	}
	
	@GetMapping("/compra/consultar/{codigoCompra}")
	public Compra consultarCompra(@PathVariable("codigoCompra") Long codigoCompra) {
		Optional<Compra> compra = compraService.obtenerCompra(codigoCompra);
		return compra.isPresent() ? compra.get() : null;
	}
	
}
