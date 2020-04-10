package com.cidenet.hulk.store.ws.producto.service;

public interface ProductoService {

	/**
	 * <p>
	 * Metodo <b>adicionarStockProducto</b> encargado de adicionar el stock a un
	 * producto cuando se realiza una compra.
	 * </p>
	 * 
	 */
	public void adicionarStockProducto(Long codigoProducto, Integer stock);
	
	/**
	 * <p>
	 * Metodo <b>removerStockProducto</b> encargado de remover el stock a un
	 * producto cuando se realiza una venta.
	 * </p>
	 * 
	 */
	public void removerStockProducto(Long codigoProducto, Integer stock);
	
}
