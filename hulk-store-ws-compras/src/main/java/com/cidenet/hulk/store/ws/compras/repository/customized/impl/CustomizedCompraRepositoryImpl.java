package com.cidenet.hulk.store.ws.compras.repository.customized.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cidenet.hulk.store.model.entity.DetalleCompra;
import com.cidenet.hulk.store.ws.compras.repository.customized.CustomizedCompraRepository;

public class CustomizedCompraRepositoryImpl implements CustomizedCompraRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public DetalleCompra guardarDetalleCompra(DetalleCompra detalleCompra) {
		return entityManager.merge(detalleCompra);
	}

}
