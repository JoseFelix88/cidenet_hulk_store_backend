/**
 * 
 */
package com.cidenet.hulk.store.ws.compras.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cidenet.hulk.store.ws.compras.HulkStoreWsComprasApplication;

/**
 * @author Thaliana
 *
 * 6:53:19 p. m. 2020
 */
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@ContextConfiguration(classes = { HulkStoreWsComprasApplication.class })
@WebAppConfiguration
public class CompraRepositoryTest {

	@Autowired 
	private CompraRepository compraRepository;
	
	@Test
	public void registrarCompra() {
		
	}
}