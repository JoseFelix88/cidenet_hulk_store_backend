/**
 * 
 */
package com.cidenet.hulk.store.ws.cliente.repository.customized;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.cidenet.hulk.store.model.entity.proxy.ReporteDetalleComprasClienteProxy;

/**
 * @author Thaliana
 *
 * 11:39:42 a. m. 2020
 */
public interface CustomizedClienteRepository {
	
	
	/**
	 * <p>
	 * Metodo <b>obtenerBalanceUltimasComprasCliente</b> encargado de obtener de forma
	 * agrupada la informacion de las ultimas compras (valor parametrizable)
	 * realizadas por el cliente parametrizado.
	 * </p>
	 * 
	 */
	@RestResource(path = "balance-ultimas-compras-cliente")
	public List<ReporteDetalleComprasClienteProxy> obtenerBalanceUltimasComprasCliente(@Param("codigoCliente") Integer codigoCliente);
	
	/**
	 * <p>
	 * Metodo <b>listarUltimasComprasCliente</b> encargado de obtener de forma
	 * detallada la informacion de las ultimas compras (valor parametrizable)
	 * realizadas por el cliente parametrizado.
	 * </p>
	 * 
	 */
	@RestResource(path = "listar-ultimas-compras-cliente")
	public List<ReporteDetalleComprasClienteProxy> listarUltimasComprasCliente(@Param("codigoCliente") Integer codigoCliente);
	
	
	
}
