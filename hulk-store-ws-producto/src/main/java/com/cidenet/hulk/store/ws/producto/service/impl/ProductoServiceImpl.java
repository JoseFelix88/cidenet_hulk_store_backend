/**
 * 
 */
package com.cidenet.hulk.store.ws.producto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cidenet.hulk.store.ws.producto.repository.ProductoRepository;
import com.cidenet.hulk.store.ws.producto.service.ProductoService;

/**
 * @author Thaliana
 *
 *         3:35:44 p. m. 2020
 */
@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	/**
	 * <p>
	 * Metodo <b>adicionarStockProducto</b> encargado de de adicionar el stock a un
	 * producto cuando se realiza una compra.
	 * </p>
	 * 
	 */
	@Override
	public void adicionarStockProducto(Long codigoProducto, Integer stock) {
		productoRepository.adicionarStockProducto(codigoProducto, stock);
	}

	/**
	 * <p>
	 * Metodo <b>removerStockProducto</b> encargado de remover el stock a un
	 * producto cuando se realiza una venta.
	 * </p>
	 * 
	 */
	@Override
	public void removerStockProducto(Long codigoProducto, Integer stock) {
		productoRepository.removerStockProducto(codigoProducto, stock);
	}

}
