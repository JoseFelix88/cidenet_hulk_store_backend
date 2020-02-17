package com.cidenet.hulk.store.ws.ventas.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cidenet.hulk.store.clients.ClienteFeingClient;
import com.cidenet.hulk.store.clients.ProductoFeingClient;
import com.cidenet.hulk.store.dto.DetalleVentaDTO;
import com.cidenet.hulk.store.dto.VentaDTO;
import com.cidenet.hulk.store.model.entity.Cliente;
import com.cidenet.hulk.store.model.entity.DetalleVenta;
import com.cidenet.hulk.store.model.entity.Producto;
import com.cidenet.hulk.store.model.entity.Venta;
import com.cidenet.hulk.store.ws.ventas.repository.VentaRepository;
import com.cidenet.hulk.store.ws.ventas.service.VentaService;

/**
 * Servicio encargado de la implementacion del CRUD para el proceso de ventas.
 * 
 * @author Thaliana
 *
 */
@Service
public class VentaServiceImpl implements VentaService {

	/**
	 * Varible encargada de imprimir el log de los procesos.
	 */
	private static final Logger LOGGER = LogManager.getLogger(VentaServiceImpl.class);

	/**
	 * Inyeccion del repositorio de ventas.
	 */
	@Autowired
	private VentaRepository ventaRepository;
	
	/**
	 * Inyección del cliente que comunica el servicio cliente con la venta registrada.
	 */
	@Autowired 
	private ClienteFeingClient clienteFeignClient;
	
	/**
	 * Inyeccion del client producto que comunica los productos registrados para el registro de la venta.
	 */
	@Autowired
	private ProductoFeingClient productoFeingClient;


	/** 
	 * <p>Metodo <b>guardarVenta</b> encargado de registrar en BD las ventas realizadas.</p>
	 * 
	 */
	@Transactional
	@Override
	public Venta guardarVenta(VentaDTO ventaDto) {
		try {
			Venta venta = new Venta();
			Cliente cliente = clienteFeignClient.findById(ventaDto.getCodigoCliente());
			venta.setCliente(cliente);
			venta.setFechaVenta(LocalDateTime.now());
			venta.setTotalVenta(ventaDto.getTotalVenta());
			Venta ventaRegistrada = ventaRepository.save(venta);
			for (DetalleVentaDTO detalleVentaDto : ventaDto.getListDetalleVenta()) {
				DetalleVenta detalleVenta = new DetalleVenta();
				detalleVenta.setVenta(ventaRegistrada);
				Producto producto = productoFeingClient.findById(detalleVentaDto.getCodigoProducto());
				detalleVenta.setProducto(producto);
				detalleVenta.setCantidadVenta(detalleVentaDto.getCantidadVenta());
				detalleVenta.setFechaRegistro(LocalDateTime.now());
				detalleVenta.setValorUnidadVenta(detalleVentaDto.getValorUnidad());
				detalleVenta.setValorTotalVenta(detalleVentaDto.getCantidadVenta() * detalleVentaDto.getValorUnidad());
				ventaRepository.guardarDetalleVenta(detalleVenta);
				productoFeingClient.removerStockProducto(producto.getCodigoProducto(), detalleVenta.getCantidadVenta());
			}
			LOGGER.info(ventaRegistrada);
			return ventaRegistrada;
		} catch (Exception e) {
			LOGGER.error("Ocurrio un error al momento de crear el registro de venta: {}", e);
			return null;
		}

	}

	/** 
	 * <p>Metodo <b>obtenerVentaById</b> encargado de consultar una venta por el codigo.</p>
	 * 
	 */
	@Override
	public Optional<Venta> obtenerVentaById(Long codigoVenta) {
		return ventaRepository.findById(codigoVenta);
	}

}
