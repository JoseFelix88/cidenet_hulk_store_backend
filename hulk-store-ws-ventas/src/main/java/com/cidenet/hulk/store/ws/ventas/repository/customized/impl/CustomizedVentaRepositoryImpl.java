package com.cidenet.hulk.store.ws.ventas.repository.customized.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cidenet.hulk.store.model.entity.DetalleVenta;
import com.cidenet.hulk.store.ws.ventas.repository.customized.CustomizedVentaRepository;

public class CustomizedVentaRepositoryImpl implements CustomizedVentaRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public DetalleVenta guardarDetalleVenta(DetalleVenta detalleVenta) {
		return entityManager.merge(detalleVenta);
	}

}
