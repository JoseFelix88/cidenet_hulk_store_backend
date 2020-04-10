package com.cidenet.hulk.store.enums;

/**
 * <p>Clase utilizada para determinar el valor constante perteneciente a TipoArchivoEnum.</p>
 * <p>Propiedades EXT_ARCHIVO_EXCEL, EXT_ARCHIVO_EXCEL_97, entre otros.</p>
 * @author Indra 
 */
public enum TipoArchivoEnum {
	/*
	EXT_ARCHVIO_EXCEL(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "EXCEL"),
	EXT_ARCHVIO_EXCEL_97(".xls", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "EXCEL"),
	EXT_ARCHVIO_PDF(".pdf", "application/pdf", "PDF"),
	EXT_ARCHVIO_TXT(".txt", "application/txt", "TXT"),
	EXT_ARCHVIO_WORD(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "WORD"),
	EXT_ARCHVIO_WORD_97(".doc", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "WORD"),
	EXT_ARCHVIO_JPG(".jpg", "application/jpg", "JPG"),
	EXT_ARCHVIO_PNG(".png", "application/png", "PNG"),
	EXT_ARCHVIO_TIF(".tif", "application/tif", "TIF"),
	EXT_ARCHVIO_ZIP(".zip", "application/zip", "ZIP"),
	EXT_ARCHVIO_RTF(".rtf", "application/rtf", "RTF"),
	EXT_ARCHVIO_RPT(".rpt", "application/x-rpt", "RPT"),
	EXT_ARCHVIO_PPT(".ppt", "application/vnd.ms-powerpoint", "PPT"),
	EXT_ARCHVIO_HTM(".htm", "text/html", "HTM"),
	EXT_ARCHVIO_HTML(".html", "text/html", "HTML"),
	EXT_ARCHVIO_ENT(".ent", "application/molecular-viewer", "ENT");*/
	
	/** The ext archivo excel. */
	EXT_ARCHIVO_EXCEL(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "EXCEL"),
	
	/** The ext archivo excel 97. */
	EXT_ARCHIVO_EXCEL_97(".xls", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "EXCEL"),
	
	/** The ext archivo pdf. */
	EXT_ARCHIVO_PDF(".pdf", "application/pdf", "PDF"),
	
	/** The ext archivo txt. */
	EXT_ARCHIVO_TXT(".txt", "application/txt", "TXT"),
	
	/** The ext archivo word. */
	EXT_ARCHIVO_WORD(".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "WORD"),
	
	/** The ext archivo word 97. */
	EXT_ARCHIVO_WORD_97(".doc", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "WORD"),
	
	/** The ext archivo jpg. */
	EXT_ARCHIVO_JPG(".jpg", "application/jpg", "JPG"),
	
	/** The ext archivo png. */
	EXT_ARCHIVO_PNG(".png", "application/png", "PNG"),
	
	/** The ext archivo tif. */
	EXT_ARCHIVO_TIF(".tif", "application/tif", "TIF"),
	
	/** The ext archivo zip. */
	EXT_ARCHIVO_ZIP(".zip", "application/zip", "ZIP"),
	
	/** The ext archivo rtf. */
	EXT_ARCHIVO_RTF(".rtf", "application/rtf", "RTF"),
	
	/** The ext archivo rpt. */
	EXT_ARCHIVO_RPT(".rpt", "application/x-rpt", "RPT"),
	
	/** The ext archivo ppt. */
	EXT_ARCHIVO_PPT(".ppt", "application/vnd.ms-powerpoint", "PPT"),
	
	/** The ext archivo htm. */
	EXT_ARCHIVO_HTM(".htm", "text/html", "HTM"),
	
	/** The ext archivo html. */
	EXT_ARCHIVO_HTML(".html", "text/html", "HTML"),
	
	/** The ext archivo ent. */
	EXT_ARCHIVO_ENT(".ent", "application/molecular-viewer", "ENT");
	
	
	/** The extension. */
	private String extension;
	
	/** The tipo contenido. */
	private String tipoContenido;
	
	/** The formato. */
	private String formato;
	
	/**
	 * Instantiates a new tipo archivo enum.
	 *
	 * @param extension the extension
	 * @param tipoContenido the tipo contenido
	 * @param formato the formato
	 */
	private TipoArchivoEnum(String extension, String tipoContenido, String formato) {
		this.extension     = extension;
		this.tipoContenido = tipoContenido;
		this.formato       = formato;
	}

	/**
	 * Gets the extension.
	 *
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}
	
	/**
	 * Gets the tipo contenido.
	 *
	 * @return the tipo contenido
	 */
	public String getTipoContenido() {
		return tipoContenido;
	}

	/**
	 * Gets the formato.
	 *
	 * @return the formato
	 */
	public String getFormato() {
		return formato;
	}
	
	/**
	 * Obtener enum X formato.
	 *
	 * @param formato the formato
	 * @return the tipo archivo enum
	 */
	public static TipoArchivoEnum obtenerEnumXFormato(String formato) {
		for (TipoArchivoEnum tipoArchivo : TipoArchivoEnum.values()) {
			if(tipoArchivo.getFormato().equals(formato)) {
				return tipoArchivo;
			}
		}
		throw new IllegalArgumentException("No se encontró un TipoArchivo con el formato ["+ formato + "].");
	}
	
	/**
	 * Obtener enum X extension.
	 *
	 * @param extension the extension
	 * @return the tipo archivo enum
	 */
	public static TipoArchivoEnum obtenerEnumXExtension(String extension) {
		for (TipoArchivoEnum tipoArchivo : TipoArchivoEnum.values()) {
			if(tipoArchivo.getExtension().equals(extension)) {
				return tipoArchivo;
			}
		}
		throw new IllegalArgumentException("No se encontró un TipoArchivo con la extensión ["+ extension + "].");
	}

}