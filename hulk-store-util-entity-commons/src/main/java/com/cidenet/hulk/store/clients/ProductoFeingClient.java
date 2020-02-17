package com.cidenet.hulk.store.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cidenet.hulk.store.model.entity.Producto;

/**
 * @author Thaliana
 *
 *         11:47:54 p. m. 2020
 */
@FeignClient(name = "servicio-productos")
public interface ProductoFeingClient {

	/**
	 * <p>
	 * Metodo <b>findById</b> encargado de consultar un producto en especifico.
	 * </p>
	 */
	@GetMapping("/productos/{codigoProducto}")
	public Producto findById(@PathVariable("codigoProducto") Integer codigoProducto);

	/**
	 * <p>
	 * Metodo <b>adicionarStockProducto</b> encargado de adicionar el stock a un
	 * producto cuando se realiza una compra.
	 * </p>
	 * 
	 */
	@GetMapping(path = "/productos/search/add-stock/{codigoProducto}/{stock}")
	public void adicionarStockProducto(@PathVariable("codigoProducto") Long codigoProducto,
			@PathVariable("stock") Integer stock);

	/**
	 * <p>
	 * Metodo <b>removerStockProducto</b> encargado de remover el stock a un
	 * producto cuando se realiza una venta.
	 * </p>
	 * 
	 */
	@GetMapping(path = "/productos/search/remove-stock/{codigoProducto}/{stock}")
	public void removerStockProducto(@PathVariable("codigoProducto") Long codigoProducto,
			@PathVariable("stock") Integer stock);

}
