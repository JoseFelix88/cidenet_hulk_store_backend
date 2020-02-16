package com.cidenet.hulk.store.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cidenet.hulk.store.model.entity.Cliente;

@FeignClient(name = "servicio-clientes")
public interface ClienteFeingClient {

	@GetMapping(value = "/clientes/{codigoCliente}")
	public Cliente findById(@PathVariable("codigoCliente") Integer codigoCliente);
}
