package com.cidenet.hulk.store.ws.ventas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cidenet.hulk.store.model.entity.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoFeingClient {

	@GetMapping("/productos/")
	public Producto findById(@RequestParam Integer codigoProducto);
}
