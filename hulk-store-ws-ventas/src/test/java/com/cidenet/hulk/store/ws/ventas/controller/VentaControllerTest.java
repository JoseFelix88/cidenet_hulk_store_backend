/**
 * 
 */
package com.cidenet.hulk.store.ws.ventas.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cidenet.hulk.store.ws.ventas.HulkStoreWsVentasApplication;

/**
 * @author Thaliana
 *
 * 10:20:33 a. m. 2020
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration( classes = HulkStoreWsVentasApplication.class )
@WebAppConfiguration
public class VentaControllerTest {

	@Autowired 
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void initMock() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void consultarVentaTest() throws Exception {
		String  consultaVentaUrl = new StringBuilder()
				.append("/venta/consultar/")
				.append("{codigoVenta}").toString();
		
		Long codigoVenta = 9L;
		
		this.mockMvc.perform(get(consultaVentaUrl, codigoVenta))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(content().json("{\r\n" + 
				"    \"codigoVenta\": 9,\r\n" + 
				"    \"fechaVenta\": \"2020-02-15T23:09:47\",\r\n" + 
				"    \"cliente\": {\r\n" + 
				"        \"codigoCliente\": 1,\r\n" + 
				"        \"numeroIdentificacion\": \"7766766\",\r\n" + 
				"        \"apellidos\": \"Garcia\",\r\n" + 
				"        \"nombres\": \"Monica Maria\",\r\n" + 
				"        \"telefono\": \"313 444 5688\",\r\n" + 
				"        \"direccion\": \"Las colinas\",\r\n" + 
				"        \"correoElectronico\": \"monica@gmail.com\",\r\n" + 
				"        \"estadoCliente\": \"ACTIVO\"\r\n" + 
				"    },\r\n" + 
				"    \"totalVenta\": 100000,\r\n" + 
				"    \"lstDetalleVenta\": [\r\n" + 
				"        {\r\n" + 
				"            \"codigoDetalleVenta\": 6,\r\n" + 
				"            \"producto\": {\r\n" + 
				"                \"codigoProducto\": 1,\r\n" + 
				"                \"codigoBarras\": \"123333333333333333\",\r\n" + 
				"                \"descripcion\": \"Mouse inalambrico Thor\",\r\n" + 
				"                \"stockActual\": 0,\r\n" + 
				"                \"costoUnitario\": 30000,\r\n" + 
				"                \"precioVenta\": 45000,\r\n" + 
				"                \"valorUtilidad\": 15000,\r\n" + 
				"                \"fechaActualizacion\": null,\r\n" + 
				"                \"fechaRegistro\": \"2020-02-09T23:59:25\",\r\n" + 
				"                \"estado\": \"ACTIVO\"\r\n" + 
				"            },\r\n" + 
				"            \"cantidadVenta\": 20,\r\n" + 
				"            \"valorUnidadVenta\": 20000,\r\n" + 
				"            \"valorTotalVenta\": 4000000,\r\n" + 
				"            \"fechaRegistro\": \"2020-02-15T23:09:47\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"codigoDetalleVenta\": 7,\r\n" + 
				"            \"producto\": {\r\n" + 
				"                \"codigoProducto\": 1,\r\n" + 
				"                \"codigoBarras\": \"123333333333333333\",\r\n" + 
				"                \"descripcion\": \"Mouse inalambrico Thor\",\r\n" + 
				"                \"stockActual\": 0,\r\n" + 
				"                \"costoUnitario\": 30000,\r\n" + 
				"                \"precioVenta\": 45000,\r\n" + 
				"                \"valorUtilidad\": 15000,\r\n" + 
				"                \"fechaActualizacion\": null,\r\n" + 
				"                \"fechaRegistro\": \"2020-02-09T23:59:25\",\r\n" + 
				"                \"estado\": \"ACTIVO\"\r\n" + 
				"            },\r\n" + 
				"            \"cantidadVenta\": 12,\r\n" + 
				"            \"valorUnidadVenta\": 20000,\r\n" + 
				"            \"valorTotalVenta\": 4000000,\r\n" + 
				"            \"fechaRegistro\": \"2020-02-15T23:09:47\"\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"            \"codigoDetalleVenta\": 8,\r\n" + 
				"            \"producto\": {\r\n" + 
				"                \"codigoProducto\": 1,\r\n" + 
				"                \"codigoBarras\": \"123333333333333333\",\r\n" + 
				"                \"descripcion\": \"Mouse inalambrico Thor\",\r\n" + 
				"                \"stockActual\": 0,\r\n" + 
				"                \"costoUnitario\": 30000,\r\n" + 
				"                \"precioVenta\": 45000,\r\n" + 
				"                \"valorUtilidad\": 15000,\r\n" + 
				"                \"fechaActualizacion\": null,\r\n" + 
				"                \"fechaRegistro\": \"2020-02-09T23:59:25\",\r\n" + 
				"                \"estado\": \"ACTIVO\"\r\n" + 
				"            },\r\n" + 
				"            \"cantidadVenta\": 24,\r\n" + 
				"            \"valorUnidadVenta\": 20000,\r\n" + 
				"            \"valorTotalVenta\": 4000000,\r\n" + 
				"            \"fechaRegistro\": \"2020-02-15T23:09:47\"\r\n" + 
				"        }\r\n" + 
				"    ]\r\n" + 
				"}", true))
		.andDo(print())
		.andReturn();
		
	}
}
