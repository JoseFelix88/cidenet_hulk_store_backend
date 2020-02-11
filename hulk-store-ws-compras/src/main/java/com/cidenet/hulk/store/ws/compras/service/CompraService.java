package com.cidenet.hulk.store.ws.compras.service;

import java.util.Optional;

import com.cidenet.hulk.store.dto.CompraDTO;
import com.cidenet.hulk.store.model.entity.Compra;

public interface CompraService {

	Compra guardarCompra(CompraDTO compraDto);
	
	Optional<Compra> obtenerCompra(Long codigoCompra);
}
