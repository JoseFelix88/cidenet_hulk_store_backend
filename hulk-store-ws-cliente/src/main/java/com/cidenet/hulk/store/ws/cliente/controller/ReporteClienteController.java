/**
 * 
 */
package com.cidenet.hulk.store.ws.cliente.controller;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cidenet.hulk.store.enums.TipoArchivoEnum;
import com.cidenet.hulk.store.utils.FechaUtil;
import com.cidenet.hulk.store.ws.cliente.constant.ViewConstant;
import com.cidenet.hulk.store.ws.cliente.service.JasperService;

/**
 * @author Thaliana
 *
 * 4:03:37 p. m. 2020
 */
@RestController
public class ReporteClienteController {


	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ReporteClienteController.class);
	
	@Autowired 
	private AbstractController abstractController;
	
	@Autowired 
	private JasperService jasperService;
	
	@Value("${limit.register}")
	private Integer limitRegister;
	
	
	private byte[] generarReporte(Long codigoCliente, String formato) {
		Map<String, Object> parametrosGeneracionReporte = new HashMap<>();
		parametrosGeneracionReporte.put("CODIGO_CLIENTE", codigoCliente);
		parametrosGeneracionReporte.put("PATCH_REPORTES",
				abstractController.getRutaReporte() + ViewConstant.RUTA_REPORTES);
		parametrosGeneracionReporte.put("LIMIT_REGISTROS", limitRegister);
		return jasperService.byteReport(parametrosGeneracionReporte,
				abstractController.getRutaReporte() + ViewConstant.RUTA_REPORTES, "reporte_datos_basicos_cliente.jasper",
				formato);
	}
	
	
	/**
	 * Método para exportar reporte TE por sucursal.
	 *
	 * @param response the response
	 * @param session the session
	 * @param formato the formato
	 * @param reporteTEPorSucursalDTO the reporte TE por sucursal DTO
	 */
	@GetMapping(value = "/clientes/reportes/datos-basicos/{codigoCliente}")
	public ResponseEntity<Resource> exportarReporteDatoBasicoCliente(@PathVariable Long codigoCliente) {
		try {
			
			HttpHeaders headers = new HttpHeaders();
			String pathStatic = "F:\\";
			String nameFileExport = "Reporte Datos Basicos Cliente "
					+ FechaUtil.localDateToString(FechaUtil.FORMATO_FECHA_DDMMYYYY, LocalDate.now()) 
					+ TipoArchivoEnum.EXT_ARCHIVO_PDF.getExtension();
			
			byte[] bFile = generarReporte(codigoCliente, TipoArchivoEnum.EXT_ARCHIVO_PDF.getFormato());
			
			if (!ObjectUtils.isEmpty(bFile)) {
				
				FileOutputStream fileExport = new FileOutputStream(pathStatic + nameFileExport);
				fileExport.write(bFile);
				fileExport.close();
				
				Path pathFileExport = Paths.get(pathStatic).resolve(nameFileExport).toAbsolutePath();
				Resource recurso = new UrlResource(pathFileExport.toUri());
				
				if(!recurso.exists() && !recurso.isReadable()) {
					throw new RuntimeException("Error: no se pudo cargar el recurso: " + nameFileExport);
				}
				
				headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
				
				return new ResponseEntity<Resource>(recurso, headers, HttpStatus.OK);
				
			}
			
		} catch (Exception e) {
			LOGGER.error("Exception", e);
		}
		

		return null;		
		
		
	}
	
}
