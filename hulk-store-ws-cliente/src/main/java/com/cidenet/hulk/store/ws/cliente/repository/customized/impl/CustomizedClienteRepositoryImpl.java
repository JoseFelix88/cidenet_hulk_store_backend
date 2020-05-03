/**
 * 
 */
package com.cidenet.hulk.store.ws.cliente.repository.customized.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Value;

import com.cidenet.hulk.store.model.entity.proxy.ReporteDetalleComprasClienteProxy;
import com.cidenet.hulk.store.ws.cliente.repository.customized.CustomizedClienteRepository;

/**
 * @author Thaliana
 *
 *         11:42:25 a. m. 2020
 */
public class CustomizedClienteRepositoryImpl implements CustomizedClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Value("${limit.register}")
	private Integer limitRegister;

	/**
	 * <p>
	 * Metodo <b>obtenerBalanceUltimasComprasCliente</b> encargado de obtener de forma
	 * agrupada la informacion de las ultimas compras (valor parametrizable)
	 * realizadas por el cliente parametrizado.
	 * </p>
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteDetalleComprasClienteProxy> obtenerBalanceUltimasComprasCliente(Integer codigoCliente) {
		StringBuilder jpql = new StringBuilder("SELECT\n"
				+ "	detalle_ventas.codigo_detalle_venta AS consecutivo_Compra,\n" + "	ventas.codigo_venta,\n"
				+ "	ventas.fecha_venta,\n" + "	producto.descripcion AS descripcion_producto,\n"
				+ "	SUM(detalle_ventas.cantidad_venta) AS cantidad_comprada,\n"
				+ "	ROUND(AVG(detalle_ventas.valor_unidad_venta)) AS valor_unidad,\n"
				+ "	ROUND(AVG(detalle_ventas.valor_unidad_venta)) * SUM(detalle_ventas.cantidad_venta) AS valor_total\n"
				+ "FROM\n" + "	ventas\n" + "INNER JOIN clientes ON ventas.codigo_cliente = clientes.codigo_cliente,\n"
				+ " producto\n"
				+ "INNER JOIN detalle_ventas ON detalle_ventas.codigo_producto = producto.codigo_producto\n" + "WHERE\n"
				+ "	ventas.codigo_venta = detalle_ventas.codigo_venta\n"
				+ "AND clientes.codigo_cliente = :codigoCliente\n"
				+ "GROUP BY producto.codigo_producto ORDER BY ventas.codigo_venta DESC LIMIT 0,:limitRegister");
		Query query = entityManager.createNativeQuery(jpql.toString(), ReporteDetalleComprasClienteProxy.class);
		query.setParameter("codigoCliente", codigoCliente);
		query.setParameter("limitRegister", limitRegister);

		return query.getResultList();
	}

	/**
	 * <p>
	 * Metodo <b>listarUltimasComprasCliente</b> encargado de obtener de forma
	 * detallada la informacion de las ultimas compras (valor parametrizable)
	 * realizadas por el cliente parametrizado.
	 * </p>
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteDetalleComprasClienteProxy> listarUltimasComprasCliente(Integer codigoCliente) {
		StringBuilder jpql = new StringBuilder("select dv.codigoDetalleVenta as CONSECUTIVO_COMPRA, "
				+ "dv.venta.codigoVenta as CODIGO_VENTA, "
				+ "dv.venta.fechaVenta as FECHA_VENTA, "
				+ "dv.producto.descripcion as DESCRIPCION_PRODUCTO, "
				+ "dv.cantidadVenta as CANTIDAD_COMPRADA, "
				+ "dv.valorUnidadVenta as VALOR_UNIDAD, "
				+ "dv.valorTotalVenta as VALOR_TOTAL "
				+ "from DetalleVenta dv "
				+ "where dv.venta.cliente.codigoCliente = :codigoCliente");
		
		Query query = entityManager.createNativeQuery(jpql.toString(), ReporteDetalleComprasClienteProxy.class);
		query.setParameter("codigoCliente", codigoCliente);
		query.setParameter("limitRegister", limitRegister);

		return query.getResultList();
	}

}
