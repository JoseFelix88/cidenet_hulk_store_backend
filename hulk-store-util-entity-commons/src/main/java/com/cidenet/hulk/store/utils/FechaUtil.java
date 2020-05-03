package com.cidenet.hulk.store.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** 
 * Clase utilizada para la gestión de las fechas.
 *      
 * @author Indra 
 */
public class FechaUtil {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(FechaUtil.class);
	
	/** The Constant FORMATO_FECHA. */
	public static final String FORMATO_FECHA = "dd/MM/yyyy";
	
	/** The Constant FORMATO_FECHA_DDMMYYYY. */
	public static final String FORMATO_FECHA_DDMMYYYY = "ddMMyyyy";
	
	/** The Constant FORMATO_FECHA_YYYYMMDD. */
	public static final String FORMATO_FECHA_YYYYMMDD = "yyyyMMdd";
	
	/** The Constant FORMATO_FECHA_DDMMYYYYHHMM. */
	public static final String FORMATO_FECHA_DDMMYYYYHHMM = "ddMMyyyyHHmm";
	
	/** The Constant FORMATO_FECHA_DDMMYYHHMM. */
	public static final String FORMATO_FECHA_DDMMYYHHMM = "ddMMyyHHmm";
	
	/** The Constant FORMATO_FECHA_DDMMYYYYHHMMSS. */
	public static final String FORMATO_FECHA_DDMMYYYYHHMMSS = "ddMMyyyyHHmmss";
	
	/** The Constant FORMATO_FECHA_DDMMYYYYHHMMSSMS. */
	public static final String FORMATO_FECHA_DDMMYYYYHHMMSSMS = "ddMMyyyyHHmmssSSS";
	
	/** The Constant FORMATO_FECHA_LETRAS. */
	public static final String FORMATO_FECHA_LETRAS = "dd 'de' MMMM 'de' yyyy";
	
	/** The Constant FORMATO_FECHA_LETRAS_DIA. */
	public static final String FORMATO_FECHA_LETRAS_DIA = "EEEE dd 'de' MMMM 'de' yyyy";
	
	/** The Constant FORMATO_FECHA_HORA. */
	public static final String FORMATO_FECHA_HORA = "dd/MM/yyyy hh:mm:ss a";
	
	/** The Constant FORMATO_HORA_MILITAR. */
	public static final String FORMATO_HORA_MILITAR = "HHmmss";
	
	/** The Constant FORMATO_FECHA_HORA_MILISEGUNDOS. */
	public static final String FORMATO_FECHA_HORA_MILISEGUNDOS = "dd/MM/yyyy hh:mm:ss.SSS a"; 
	
	/** The Constant HORA_INICIO_DIA. */
	public static final String HORA_INICIO_DIA = " 00:00:00 AM";
	
	/** The Constant HORA_FIN_DIA. */
	public static final String HORA_FIN_DIA = " 11:59:59 PM";
	
	/** The Constant locale. */
	public static final Locale locale = new Locale("es", "CO");
	
    /**
     * Instantiates a new fecha util.
     */
    private FechaUtil() {
		
	}

    /**
     * Format date.
     *
     * @param formato the formato
     * @param fecha the fecha
     * @return the string
     */
    public static String formatDate(String formato, Date fecha) {
    	return new SimpleDateFormat(formato).format(fecha);
    }
    
    /**
     * Format string to date.
     *
     * @param formato the formato
     * @param fecha the fecha
     * @return the date
     * @throws ParseException the parse exception
     */
    public static Date formatStringToDate(String formato, String fecha) throws ParseException {
    	return new SimpleDateFormat(formato).parse(fecha);
    }
    
	/**
	 * String to local date.
	 *
	 * @param formato the formato
	 * @param fecha the fecha
	 * @return the local date
	 */
	public static LocalDate stringToLocalDate(String formato, String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato, locale);
		return LocalDate.parse(fecha, formatter);
	}
	
	/**
	 * String to local date time.
	 *
	 * @param formato the formato
	 * @param fecha the fecha
	 * @return the local date time
	 */
	public static LocalDateTime stringToLocalDateTime(String formato, String fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato, locale);
		return LocalDateTime.parse(fecha, formatter);
	}
	
	/**
	 * Local date to string.
	 *
	 * @param formato the formato
	 * @param fecha the fecha
	 * @return the string
	 */
	public static String localDateToString(String formato, LocalDate fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato, locale);
		return fecha.format(formatter);
	}
	
	/**
	 * Local date time to string.
	 *
	 * @param formato the formato
	 * @param fecha the fecha
	 * @return the string
	 */
	public static String localDateTimeToString(String formato, LocalDateTime fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato, locale);
		return fecha.format(formatter);
	}
	
	/**
	 * String to local time.
	 *
	 * @param hora the hora
	 * @return the local time
	 */
	public static LocalTime stringToLocalTime(String hora) {
		return LocalTime.parse(hora);
	}
	
	/**
	 * Util date to local date time.
	 *
	 * @param fecha the fecha
	 * @return the local date time
	 */
	public static LocalDateTime utilDateToLocalDateTime(Date fecha) {
		return LocalDateTime.ofInstant(fecha.toInstant(), ZoneId.systemDefault());
	}
	
	/**
	 * Util local date time to date.
	 *
	 * @param fecha the fecha
	 * @return the date
	 */
	public static Date utilLocalDateTimeToDate(LocalDateTime fecha) {
		return Date.from(fecha.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	/**
	 * Local date to XML gregorian calendar.
	 *
	 * @param fecha the fecha
	 * @return the XML gregorian calendar
	 */
	public static XMLGregorianCalendar localDateToXMLGregorianCalendar(LocalDate fecha) {
		GregorianCalendar gcal = GregorianCalendar.from(fecha.atStartOfDay(ZoneId.systemDefault()));
		XMLGregorianCalendar xcal = null;
		try {
			xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		} catch (DatatypeConfigurationException e) {
			LOGGER.error(e);
		}
		return xcal;
	}

}
