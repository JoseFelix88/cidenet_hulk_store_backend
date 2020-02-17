package com.cidenet.hulk.store.ws.compras.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cidenet.hulk.store.clients.ProductoFeingClient;
import com.cidenet.hulk.store.clients.ProveedorFeingClient;
import com.cidenet.hulk.store.dto.CompraDTO;
import com.cidenet.hulk.store.dto.DetalleCompraDTO;
import com.cidenet.hulk.store.model.entity.Compra;
import com.cidenet.hulk.store.model.entity.DetalleCompra;
import com.cidenet.hulk.store.model.entity.Producto;
import com.cidenet.hulk.store.model.entity.Proveedor;
import com.cidenet.hulk.store.ws.compras.repository.CompraRepository;
import com.cidenet.hulk.store.ws.compras.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {

	private static final Logger LOGGER = LogManager.getLogger(CompraServiceImpl.class);
	
	@Autowired 
	private CompraRepository compraRepository;
	
	@Autowired 
	private ProveedorFeingClient proveedorFeingClient;
	
	@Autowired 
	private ProductoFeingClient productoFeingClient;
	
	
	@Transactional
	@Override
	public Compra guardarCompra(CompraDTO compraDto) {
		try {
			Compra compra = new Compra();
			compra.setFechaCompra(LocalDateTime.now());
			Proveedor proveedor = proveedorFeingClient.findById(compraDto.getCodigoProveedor());
			compra.setProveedor(proveedor);
			compra.setTotalCompra(compraDto.getTotalCompra());
			compra.setNumeroFacturaCompra(compraDto.getNumeroFacturaCompra());
			compra.setFechaFacturaCompra(compraDto.getFechaFacturaCompra());
			Compra compraRegistrada = compraRepository.save(compra);
			for (DetalleCompraDTO detalleCompraDto : compraDto.getListDetalleCompra()) {
				DetalleCompra detalleCompra = new DetalleCompra();
				detalleCompra.setCompra(compraRegistrada);
				Producto producto = productoFeingClient.findById(detalleCompraDto.getCodigoProducto());
				detalleCompra.setProducto(producto);
				detalleCompra.setCantidadCompra(detalleCompraDto.getCantidadCompra());
				detalleCompra.setCostoUnidadCompra(detalleCompraDto.getValorUnidad());
				detalleCompra.setCostoTotalCompra(detalleCompraDto.getCantidadCompra() * detalleCompraDto.getValorUnidad());
				compraRepository.guardarDetalleCompra(detalleCompra);
				productoFeingClient.adicionarStockProducto(producto.getCodigoProducto(), detalleCompra.getCantidadCompra());
			}
			LOGGER.info(compraRegistrada);
			return compraRegistrada;
		} catch (Exception e) {
			LOGGER.error("Ocurrio un error al momento de crear el registro de compra: {} ", e.getMessage());
			return null;
		}
		
	}

	@Override
	public Optional<Compra> obtenerCompra(Long codigoCompra) {
		return compraRepository.findById(codigoCompra);
	}

}
