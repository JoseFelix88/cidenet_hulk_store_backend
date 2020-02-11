package com.cidenet.hulk.store.ws.ventas.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cidenet.hulk.store.dto.DetalleVentaDTO;
import com.cidenet.hulk.store.dto.VentaDTO;
import com.cidenet.hulk.store.model.entity.Cliente;
import com.cidenet.hulk.store.model.entity.DetalleVenta;
import com.cidenet.hulk.store.model.entity.Producto;
import com.cidenet.hulk.store.model.entity.Venta;
import com.cidenet.hulk.store.ws.ventas.repository.VentaRepository;
import com.cidenet.hulk.store.ws.ventas.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

	private static final Logger LOGGER = LogManager.getLogger(VentaServiceImpl.class);

	@Autowired
	private VentaRepository ventaRepository;

	@Transactional
	@Override
	public Venta guardarVenta(VentaDTO ventaDto) {
		try {
			Venta venta = new Venta();
			Cliente cliente = new Cliente();
			cliente.setCodigoCliente(ventaDto.getCodigoCliente());
			venta.setCliente(cliente);
			venta.setFechaVenta(LocalDateTime.now());
			venta.setTotalVenta(ventaDto.getTotalVenta());
			Venta ventaRegistrada = ventaRepository.save(venta);
			for (DetalleVentaDTO detalleVentaDto : ventaDto.getListDetalleVenta()) {
				DetalleVenta detalleVenta = new DetalleVenta();
				detalleVenta.setVenta(ventaRegistrada);
				Producto producto = new Producto();
				producto.setCodigoProducto(Long.valueOf(detalleVentaDto.getCodigoProducto()));
				detalleVenta.setProducto(producto);
				detalleVenta.setCantidadVenta(detalleVentaDto.getCantidadVenta());
				detalleVenta.setFechaRegistro(LocalDateTime.now());
				detalleVenta.setValorUnidadVenta(detalleVentaDto.getValorUnidad());
				detalleVenta.setValorTotalVenta(detalleVentaDto.getCantidadVenta() * detalleVentaDto.getValorUnidad());
				ventaRepository.guardarDetalleVenta(detalleVenta);
			}
			LOGGER.info(ventaRegistrada);
			return ventaRegistrada;
		} catch (Exception e) {
			LOGGER.error("Ocurrio un error al momento de crear el registro de venta: {} ", e.getMessage());
			return null;
		}

	}

	@Override
	public Optional<Venta> obtenerVentaById(Long codigoVenta) {
		return ventaRepository.findById(codigoVenta);
	}

}
