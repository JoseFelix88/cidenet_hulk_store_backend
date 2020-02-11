package com.cidenet.hulk.store.ws.ventas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cidenet.hulk.store.model.entity.Cliente;

@FeignClient(name = "servicio-clientes")
public interface ClienteFeingClient {

	@GetMapping(value = "/clientes/", produces = {"application/json"})
	public Cliente findById(@RequestParam Integer codigoCliente);
}
