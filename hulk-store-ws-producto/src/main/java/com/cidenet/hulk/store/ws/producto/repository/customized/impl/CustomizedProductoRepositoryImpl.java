/**
 * 
 */
package com.cidenet.hulk.store.ws.producto.repository.customized.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.cidenet.hulk.store.ws.producto.repository.customized.CustomizedProductoRepository;

/**
 * @author Thaliana
 *
 *         11:57:18 p. m. 2020
 */
public class CustomizedProductoRepositoryImpl implements CustomizedProductoRepository {

	private static final Logger LOGGER = LogManager.getLogger(CustomizedProductoRepositoryImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * <p>
	 * Metodo <b>adicionarStockProducto</b> encargado de adicionar el stock a un
	 * producto cuando se realiza una compra.
	 * </p>
	 * 
	 */
	@Transactional
	@Override
	public void adicionarStockProducto(Long codigoProducto, Integer stock) {
		try {
			StringBuilder jpql = new StringBuilder();
			jpql.append(
					"Update Producto Set stockActual = stockActual + :stock Where codigoProducto = :codigoProducto");
			Query query = entityManager.createQuery(jpql.toString());
			query.setParameter("stock", stock);
			query.setParameter("codigoProducto", codigoProducto);
			query.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Se presento el siguiente error al momento de adicionar stock: {}", e);
		}
	}

	/**
	 * <p>
	 * Metodo <b>removerStockProducto</b> encargado de remover el stock a un
	 * producto cuando se realiza una venta.
	 * </p>
	 * 
	 */
	@Transactional
	@Override
	public void removerStockProducto(Long codigoProducto, Integer stock) {
		try {
			StringBuilder jpql = new StringBuilder();
			jpql.append(
					"Update Producto Set stockActual = stockActual - :stock Where codigoProducto = :codigoProducto");
			Query query = entityManager.createQuery(jpql.toString());
			query.setParameter("stock", stock);
			query.setParameter("codigoProducto", codigoProducto);
			query.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Se presento el siguiente error al momento de remover stock: {}", e);
		}
	}

}
