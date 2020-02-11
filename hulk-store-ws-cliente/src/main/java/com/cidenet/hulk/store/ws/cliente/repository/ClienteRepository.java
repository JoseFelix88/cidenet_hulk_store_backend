package com.cidenet.hulk.store.ws.cliente.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cidenet.hulk.store.model.entity.Cliente;

@RepositoryRestResource(path = "clientes")
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {

}
