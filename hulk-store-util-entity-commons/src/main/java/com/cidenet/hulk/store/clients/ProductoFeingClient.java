package com.cidenet.hulk.store.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cidenet.hulk.store.model.entity.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoFeingClient {

	@GetMapping("/productos/{codigoProducto}")
	public Producto findById(@PathVariable("codigoProducto") Integer codigoProducto);
}
