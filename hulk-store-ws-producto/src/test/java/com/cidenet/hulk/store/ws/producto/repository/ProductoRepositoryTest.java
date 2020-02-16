/**
 * 
 */
package com.cidenet.hulk.store.ws.producto.repository;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cidenet.hulk.store.enums.EstadoActivoInactivoEnum;
import com.cidenet.hulk.store.model.entity.Producto;
import com.cidenet.hulk.store.ws.producto.HulkStoreWsProductoApplication;

/**
 * @author Thaliana
 *
 * 5:30:52 p. m. 2020
 */
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@ContextConfiguration(classes = { HulkStoreWsProductoApplication.class })
@WebAppConfiguration
public class ProductoRepositoryTest {

	private static final Logger LOGGER = LogManager.getLogger(ProductoRepositoryTest.class);

	@Autowired
	private ProductoRepository productoRepository;

	@Commit
	@Test
	public void registrarProducto() {
		try {
			Producto producto = new Producto();
			producto.setCodigoBarras("1014006016067");
			producto.setDescripcion("Mini Iron Man");
			producto.setStockActual(12);
			producto.setValorUtilidad(10000);
			producto.setCostoUnitario(10000);
			producto.setPrecioVenta(20000);
			producto.setEstado(EstadoActivoInactivoEnum.ACTIVO);
			producto.setFechaRegistro(LocalDateTime.now());
			Producto productoRegistrado = productoRepository.save(producto);
			LOGGER.info("Se ha registrado la siguiente información: {}", productoRegistrado);
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error("El test de registro presenta el siguiente error: {}", e);
			assertTrue(false);
		}
	}
	
	@Commit
	@Test
	public void actualizarProducto() {
		try {
			Optional<Producto> producto = productoRepository.findById(4L);
			if(producto.isPresent()) {
				producto.get().setCodigoBarras("2214006016067");
				producto.get().setDescripcion("Hulk grande importado.".toUpperCase());
				producto.get().setStockActual(12);
				producto.get().setValorUtilidad(10000);
				producto.get().setCostoUnitario(10000);
				producto.get().setPrecioVenta(20000);
				producto.get().setEstado(EstadoActivoInactivoEnum.ACTIVO);
				producto.get().setFechaActualizacion(LocalDateTime.now());
				Producto productoRegistrado = productoRepository.save(producto.get());
				LOGGER.info("Se ha registrado la siguiente información: {}", productoRegistrado);
			}
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error("El test de registro presenta el siguiente error: {}", e);
			assertTrue(false);
		}
	}
	
	@Test
	public void consultarProducto() {
		try {
			Optional<Producto> producto = productoRepository.findById(2L);
			if (producto.isPresent()) {
				LOGGER.info(producto);
			}
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error("El test de consulta presenta el siguiente error: {}", e);
			assertTrue(false);
		}
	}

}
