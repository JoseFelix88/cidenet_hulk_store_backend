/**
 * 
 */
package com.cidenet.hulk.store.ws.producto.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet.hulk.store.ws.producto.service.ProductoService;

/**
 * @author Thaliana
 *
 *         3:38:53 p. m. 2020
 */
@RestController
public class ProductoController {

private static final Logger LOGGER = LogManager.getLogger(ProductoController.class);
	
	/**
	 * Inyeccion del bean ProductoService
	 */
	@Autowired
	private ProductoService productoService;

	/**
	 * <p>
	 * Metodo <b>adicionarStockProducto</b> encargado de mapear la petición y hacer
	 * el llamado al servicio para posteriormente adicionar el stock al producto.
	 * </p>
	 */
	@PutMapping("/productos/add-stock/{codigoProducto}/{stock}")
	public void adicionarStockProducto(@PathVariable("codigoProducto") Long codigoProducto,
			@PathVariable("stock") Integer stock) {
		try {

			productoService.adicionarStockProducto(codigoProducto, stock);
			
		} catch (Exception e) {
			LOGGER.error("Error al momento de adicionar Stock al producto.", e);
		}
	}
	
	/**
	 * <p>
	 * Metodo <b>adicionarStockProducto</b> encargado de mapear la petición y hacer
	 * el llamado al servicio para posteriormente remover el stock al producto.
	 * </p>
	 */
	@PutMapping("/productos/remove-stock/{codigoProducto}/{stock}")
	public void removerStockProducto(@PathVariable("codigoProducto") Long codigoProducto,
			@PathVariable("stock") Integer stock) {
		try {
			productoService.removerStockProducto(codigoProducto, stock);
		} catch (Exception e) {
			LOGGER.error("Error al momento de remover Stock al producto.", e);
		}
	}
}
