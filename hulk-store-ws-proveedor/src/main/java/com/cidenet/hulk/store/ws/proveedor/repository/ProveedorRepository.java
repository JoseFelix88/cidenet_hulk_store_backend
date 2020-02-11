package com.cidenet.hulk.store.ws.proveedor.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cidenet.hulk.store.model.entity.Proveedor;

@RepositoryRestResource(path = "proveedores")
public interface ProveedorRepository extends PagingAndSortingRepository<Proveedor, Integer>{

}
