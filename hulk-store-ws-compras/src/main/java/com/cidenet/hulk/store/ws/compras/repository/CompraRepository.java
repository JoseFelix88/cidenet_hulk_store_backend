package com.cidenet.hulk.store.ws.compras.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cidenet.hulk.store.model.entity.Compra;
import com.cidenet.hulk.store.ws.compras.repository.customized.CustomizedCompraRepository;

@Repository
public interface CompraRepository extends PagingAndSortingRepository<Compra, Long>, CustomizedCompraRepository {

}
