/**
 * 
 */
package com.cidenet.hulk.store.ws.ventas.repository;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cidenet.hulk.store.model.entity.Cliente;
import com.cidenet.hulk.store.model.entity.DetalleVenta;
import com.cidenet.hulk.store.model.entity.Producto;
import com.cidenet.hulk.store.model.entity.Venta;
import com.cidenet.hulk.store.ws.ventas.HulkStoreWsVentasApplication;

/**
 * <p>
 * Clase de prueba para el repository de ventas.
 * </p>
 * 
 * @author Thaliana
 *
 *         10:44:04 p. m. 2020
 */
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@ContextConfiguration(classes = { HulkStoreWsVentasApplication.class })
@ImportAutoConfiguration({ MessageSourceAutoConfiguration.class, RibbonAutoConfiguration.class,
		FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class })
@WebAppConfiguration
@ComponentScan("com.cidenet.hulk.store.ws.ventas")
public class VentaRepositoryTest {

	private static final Logger LOGGER = LogManager.getLogger(VentaRepositoryTest.class);

	@Autowired
	private VentaRepository ventaRepository;
	
	
	@Commit
	@Test
	public void guardarVentaTest() {
		try {
			Venta venta = new Venta();
			Cliente cliente = new Cliente();
			cliente.setCodigoCliente(1);
			venta.setCliente(cliente);
			venta.setFechaVenta(LocalDateTime.now());
			venta.setTotalVenta(100000);
			Venta ventaRegistrada = ventaRepository.save(venta);
			List<DetalleVenta> lstDetalleVenta = new ArrayList<>();
			Producto producto = new Producto();
			producto.setCodigoProducto(1L);
			DetalleVenta detalle1 = new DetalleVenta(ventaRegistrada, producto, 20, 20000,
					(20*200000), LocalDateTime.now());
			DetalleVenta detalle2 = new DetalleVenta(ventaRegistrada, producto, 12, 20000,
					(20*200000), LocalDateTime.now());
			DetalleVenta detalle3 = new DetalleVenta(ventaRegistrada, producto, 24, 20000,
					(20*200000), LocalDateTime.now());
			lstDetalleVenta.add(detalle1);
			lstDetalleVenta.add(detalle2);
			lstDetalleVenta.add(detalle3);
			lstDetalleVenta.forEach(detalleVenta -> ventaRepository.guardarDetalleVenta(detalleVenta));
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error(e);
			assertTrue(false);
		}
	}

	/**
	 * <p>
	 * Metodo <b>obtenerVentaByIdTest</b> encargado de consultar una venta por el
	 * numero.
	 * </p>
	 */
	@Test
	public void obtenerVentaByIdTest() {
		try {
			Optional<Venta> venta = ventaRepository.findById(9L);
			if (venta.isPresent()) {
				LOGGER.info(venta.get());
				venta.get().getLstDetalleVenta().forEach(detalle -> LOGGER.info(detalle));
			}
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error(e);
			assertTrue(false);
		}
	}

	
}
