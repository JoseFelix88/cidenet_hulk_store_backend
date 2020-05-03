package com.cidenet.hulk.store.ws.cliente.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cidenet.hulk.store.model.entity.Cliente;
import com.cidenet.hulk.store.ws.cliente.repository.customized.CustomizedClienteRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, methods = { RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE, RequestMethod.GET, RequestMethod.HEAD }, allowedHeaders = "*")
@RepositoryRestResource(path = "clientes")
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer>, CustomizedClienteRepository {

}
