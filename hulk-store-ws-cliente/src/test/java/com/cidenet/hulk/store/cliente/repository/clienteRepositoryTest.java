/**
 * 
 */
package com.cidenet.hulk.store.cliente.repository;

import static org.junit.Assert.assertTrue;

import java.util.List;
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

import com.cidenet.hulk.store.model.entity.Cliente;
import com.cidenet.hulk.store.model.entity.proxy.ReporteDetalleComprasClienteProxy;
import com.cidenet.hulk.store.ws.cliente.HulkStoreWsClienteApplication;
import com.cidenet.hulk.store.ws.cliente.repository.ClienteRepository;

/**
 * @author Thaliana
 *
 * 5:55:13 p. m. 2020
 */
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@ContextConfiguration(classes = { HulkStoreWsClienteApplication.class })
@WebAppConfiguration
public class clienteRepositoryTest {

	private static final Logger LOGGER = LogManager.getLogger(clienteRepositoryTest.class);

	@Autowired
	private ClienteRepository clienteRepository;

	@Commit
	@Test
	public void registrarCliente() {
		try {
			Cliente cliente = new Cliente();
			cliente.setApellidos("PeresZozo");
			cliente.setNombres("Marina");
			cliente.setDireccion("Nariño");
			cliente.setTelefono("233 344 22 33");
			cliente.setNumeroIdentificacion("100299900");
			Cliente clienteRegistrado = clienteRepository.save(cliente);
			LOGGER.info("Se ha registrado la siguiente información: {}", clienteRegistrado);
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error("El test de registro presenta el siguiente error: {}", e);
			assertTrue(false);
		}
	}
	
	@Commit
	@Test
	public void actualizarCliente() {
		try {
			Optional<Cliente> cliente = clienteRepository.findById(4);
			if(cliente.isPresent()) {
				cliente.get().setNumeroIdentificacion("2214006016067");
				cliente.get().setApellidos("Diaz");
				cliente.get().setNombres("Diomedes");;
				cliente.get().setTelefono("20019999");
				cliente.get().setDireccion("Sincelejo");
				Cliente clienteRegistrado = clienteRepository.save(cliente.get());
				LOGGER.info("Se ha registrado la siguiente información: {}", clienteRegistrado);
			}
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error("El test de registro presenta el siguiente error: {}", e);
			assertTrue(false);
		}
	}
	
	@Test
	public void consultarCliente() {
		try {
			Optional<Cliente> cliente = clienteRepository.findById(4);
			if (cliente.isPresent()) {
				LOGGER.info(cliente);
			}
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error("El test de consulta presenta el siguiente error: {}", e);
			assertTrue(false);
		}
	}
	
	@Test
	public void obtenerBalanceUltimasComprasCliente() {
		try {
			List<ReporteDetalleComprasClienteProxy> lstComprasCliente = clienteRepository.obtenerBalanceUltimasComprasCliente(2);
			lstComprasCliente.forEach(compras -> LOGGER.info(compras));
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error("El test de consulta presenta el siguiente error: {}", e);
			assertTrue(false);
		}
	}
	
}
