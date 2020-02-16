/**
 * 
 */
package com.cidenet.hulk.store.ws.proveedor.repository;



import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
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
import com.cidenet.hulk.store.model.entity.Proveedor;
import com.cidenet.hulk.store.ws.proveedor.HulkStoreWsProveedorApplication;

/**
 * @author Thaliana
 *
 *         4:30:23 p. m. 2020
 */
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@ContextConfiguration(classes = { HulkStoreWsProveedorApplication.class })
@WebAppConfiguration
public class ProveedorRepositoryTest {

	private static final Logger LOGGER = LogManager.getLogger(ProveedorRepositoryTest.class);

	@Autowired
	private ProveedorRepository proveedorRepository;

	@Commit
	@Test
	public void registrarProveedor() {
		try {
			Proveedor proveedor = new Proveedor();
			proveedor.setRazonSocial("Cidenet S.A.S");
			proveedor.setDireccion("Medellin");
			proveedor.setTelefono("318 0009999");
			proveedor.setContacto("Claudia Arboleda");
			proveedor.setTelefonoContacto("322 3399 999");
			proveedor.setNit("900129999-1");
			proveedor.setEstadoProveedor(EstadoActivoInactivoEnum.ACTIVO);
			Proveedor proveedorRegistrado = proveedorRepository.save(proveedor);
			LOGGER.info("Se ha registrado el siguiente proveedor: {}", proveedorRegistrado);
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error("El test de registro presenta el siguiente error: {}", e);
			assertTrue(false);
		}
	}
	
	@Test
	public void consultarProveedor() {
		try {
			Optional<Proveedor> proveedor = proveedorRepository.findById(2);
			if (proveedor.isPresent()) {
				LOGGER.info(proveedor);
			}
			assertTrue(true);
		} catch (Exception e) {
			LOGGER.error("El test de consulta presenta el siguiente error: {}", e);
			assertTrue(false);
		}
	}

}
