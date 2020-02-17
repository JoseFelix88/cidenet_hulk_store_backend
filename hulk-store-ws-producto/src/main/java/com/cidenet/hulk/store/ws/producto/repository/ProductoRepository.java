package com.cidenet.hulk.store.ws.producto.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cidenet.hulk.store.model.entity.Producto;
import com.cidenet.hulk.store.ws.producto.repository.customized.CustomizedProductoRepository;

@RepositoryRestResource(path = "productos")
public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>, CustomizedProductoRepository {

}
