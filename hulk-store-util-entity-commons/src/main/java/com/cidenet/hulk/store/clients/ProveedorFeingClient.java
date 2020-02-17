package com.cidenet.hulk.store.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cidenet.hulk.store.model.entity.Proveedor;

@FeignClient(name = "servicio-proveedores")
public interface ProveedorFeingClient {

	@GetMapping(value = "/proveedores/{codigoProveedor}")
	public Proveedor findById(@PathVariable("codigoProveedor") Integer codigoProveedor);
	
}
