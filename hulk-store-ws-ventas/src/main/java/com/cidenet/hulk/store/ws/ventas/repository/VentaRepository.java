package com.cidenet.hulk.store.ws.ventas.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cidenet.hulk.store.model.entity.Venta;
import com.cidenet.hulk.store.ws.ventas.repository.customized.CustomizedVentaRepository;

@Repository
public interface VentaRepository extends PagingAndSortingRepository<Venta, Long>, CustomizedVentaRepository {

}
