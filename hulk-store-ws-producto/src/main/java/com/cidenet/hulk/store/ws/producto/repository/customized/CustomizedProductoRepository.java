package com.cidenet.hulk.store.ws.producto.repository.customized;

import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author Thaliana
 *
 * 11:54:44 p. m. 2020
 */
public interface CustomizedProductoRepository {

	/**
	 * <p>
	 * Metodo <b>adicionarStockProducto</b> encargado de adicionar el stock a un
	 * producto cuando se realiza una compra.
	 * </p>
	 * 
	 */
	@RestResource(path = "add-stock")
	public void adicionarStockProducto(Long codigoProducto, Integer stock);
	
	/**
	 * <p>
	 * Metodo <b>removerStockProducto</b> encargado de remover el stock a un
	 * producto cuando se realiza una venta.
	 * </p>
	 * 
	 */
	@RestResource(path = "remove-stock")
	public void removerStockProducto(Long codigoProducto, Integer stock);
}
