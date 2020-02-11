package com.cidenet.hulk.store.ws.compras.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cidenet.hulk.store.model.entity.Proveedor;

@FeignClient(name = "servicio-proveedores")
public interface ProveedorFeingClient {

	@GetMapping("/proveedores/")
	public Proveedor findById(@RequestParam Integer codigoProveedor);
}
