/**
 * 
 */
package com.cidenet.hulk.store.ws.ventas.service;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.cidenet.hulk.store.dto.DetalleVentaDTO;
import com.cidenet.hulk.store.dto.VentaDTO;
import com.cidenet.hulk.store.model.entity.Venta;
import com.cidenet.hulk.store.ws.ventas.HulkStoreWsVentasApplication;

/**
 * Clase de prueba para el servicio ventas.
 * 
 * @author Thaliana
 *
 *         4:58:51 p. m. 2020
 */

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@ContextConfiguration(classes = { HulkStoreWsVentasApplication.class })
@ImportAutoConfiguration({ MessageSourceAutoConfiguration.class, RibbonAutoConfiguration.class,
		FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class })
@WebAppConfiguration
@ComponentScan("com.cidenet.hulk.store.ws.ventas")
public class VentaServiceTest {

	private static final Logger LOGGER = LogManager.getLogger(VentaServiceTest.class);

	@Autowired(required = true)
	@Qualifier(value = "ventaServiceImpl")
	private VentaService ventaService;

	/**
	 * <p>
	 * Metodo <b>guardarVentaTest</b> encargado de probar el registro de una venta.
	 * </p>
	 */
	@Commit
	@Test
	public void guardarVentaTest() {
		try {
			VentaDTO ventaDto = new VentaDTO();
			ventaDto.setCodigoCliente(1);
			ventaDto.setFechaVenta(LocalDate.now());
			ventaDto.setTotalVenta(100000);
			List<DetalleVentaDTO> lstDetalleVenta = new ArrayList<>();
			DetalleVentaDTO detalle1 = new DetalleVentaDTO(1L, 20, 20000);
			DetalleVentaDTO detalle2 = new DetalleVentaDTO(1L, 12, 19800);
			DetalleVentaDTO detalle3 = new DetalleVentaDTO(1L, 24, 17000);
			lstDetalleVenta.add(detalle1);
			lstDetalleVenta.add(detalle2);
			lstDetalleVenta.add(detalle3);
			ventaDto.setListDetalleVenta(lstDetalleVenta);
			ventaService.guardarVenta(ventaDto);
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
			Optional<Venta> venta = ventaService.obtenerVentaById(8L);
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
