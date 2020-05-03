/**
 * 
 */
package com.cidenet.hulk.store.ws.cliente.service;

import java.io.File;
import java.util.Map;

/**
 *  
 * <p>
 * Interfaz utilizada para gestionar los servicios para los diferentes reportes
 * que se generan en la APP en sus formatos PDF y Excel.
 * </p>
 * 
 * @author Thaliana
 *
 *         3:32:07 p. m. 2020
 */
public interface JasperService {

	/**
	 * Método encargado de generar los archivos que se exportan en formato PDF, XLSX
	 * y TXT. Como por ejemplo los reportes de log y demás reportes de la app. Byte
	 * report.
	 *
	 * @param parametros   the parametros
	 * @param url          the url
	 * @param nombreJasper the nombre jasper
	 * @param tipo         the tipo
	 * @return the byte[]
	 */
	byte[] byteReport(Map<String, Object> parametros, String url, String nombreJasper, String tipo);

	/**
	 * Método que obtiene el array de byte de un archivo en una ruta específica.
	 * Byte file.
	 * 
	 * @param url the url
	 * @return the byte[]
	 */
	byte[] byteFile(String url);

	/**
	 * Método que obtiene el array de byte de un archivo en una ruta específica.
	 * Byte file.
	 * 
	 * @param file the file
	 * @return the byte[]
	 */
	byte[] byteFile(File file);

}
