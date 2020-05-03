/**
 * 
 */
package com.cidenet.hulk.store.ws.cliente.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.cidenet.hulk.store.ws.cliente.repository.JasperRepository;
import com.cidenet.hulk.store.ws.cliente.service.JasperService;

import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.fill.JRAbstractLRUVirtualizer;
import net.sf.jasperreports.engine.fill.JRSwapFileVirtualizer;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSwapFile;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

/**
 * @author Thaliana
 *
 * 3:41:57 p. m. 2020
 */
@Service
public class JasperServiceImpl implements JasperService {


	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(JasperServiceImpl.class);
	
	@Autowired 
	private JasperRepository jasperRepository;
	
	/**
     * Método encargado de generar los archivos que se exportan en formato PDF, XLSX y TXT. 
     * Como por ejemplo los reportes de log y demás reportes de la app.
     * Byte report.
     *
     * @param parametros the parametros
     * @param fileURL the file URL
     * @param nombreJasper the nombre jasper
     * @param tipo the tipo
     * @return the byte[]
     */
	@Override
	 public byte[] byteReport(Map<String, Object> parametros, String fileURL, String nombreJasper, String tipo) {
    	ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        try {
            File file = new File(fileURL + nombreJasper); 
            JasperReport reporteMaster = (JasperReport) JRLoader.loadObject(file);
            
            Locale locale = new Locale( "es", "CO" );
            
            JRSwapFile swapFile = new JRSwapFile(System.getProperty("java.io.tmpdir"), 4096, 200);
            JRAbstractLRUVirtualizer virtualizer = new JRSwapFileVirtualizer(2, swapFile, true);
            virtualizer.setReadOnly(false);
            
            parametros.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
            parametros.put(JRParameter.REPORT_LOCALE, locale);
            
            if("EXCEL".equals(tipo)) {
            	parametros.put(JRParameter.IS_IGNORE_PAGINATION, Boolean.TRUE); 
            }
            
            JasperPrint print = JasperFillManager.fillReport(reporteMaster, parametros, jasperRepository.connectionEntity());
           
            if("EXCEL".equals(tipo)){
            	JRXlsxExporter exporterXLSX = new JRXlsxExporter();
            	exporterXLSX.setExporterInput(new SimpleExporterInput(print));
            	exporterXLSX.setExporterOutput(new SimpleOutputStreamExporterOutput(bytestream));
            	exporterXLSX.exportReport();
            	
            }else if("PDF".equals(tipo)){
            	JRPdfExporter exporterPDF = new JRPdfExporter();
            	exporterPDF.setExporterInput(new SimpleExporterInput(print));
            	exporterPDF.setExporterOutput(new SimpleOutputStreamExporterOutput(bytestream));
            	exporterPDF.exportReport();
            }else if("WORD".equals(tipo)) {
            	JRDocxExporter exporterDoc = new JRDocxExporter();
            	exporterDoc.setExporterInput(new SimpleExporterInput(print));
            	exporterDoc.setExporterOutput(new SimpleOutputStreamExporterOutput(bytestream));
            	exporterDoc.exportReport();
            }
            
            byte[] bytes = bytestream.toByteArray();
            if (bytes.length >= 853 && bytes.length <= 854) {
                return new byte[0];
            } else {
                return bytes;
            }
        } catch (Exception e) {
        	LOGGER.error("ocurrio un error = "+e);
        	LOGGER.error(e.getStackTrace().toString());
            return new byte[0];
        } finally {
        	if(!ObjectUtils.isEmpty(bytestream)) {
        		try {
					bytestream.close();
					LOGGER.info("Cerror el bytestream");
				} catch (IOException e) {
					LOGGER.error(e.getCause());
				}
        	}
        }
	}

	/** 
	 * <p>Metodo <b>byteFile</b> encargado de </p>
	 * 
	 */
	@Override
	public byte[] byteFile(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * <p>Metodo <b>byteFile</b> encargado de </p>
	 * 
	 */
	@Override
	public byte[] byteFile(File file) {
		// TODO Auto-generated method stub
		return null;
	}

}
