/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cidenet.hulk.store.ws.cliente.controller;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.annotation.ApplicationScope;


/**
 * Clase utilizada para entrar al contexto de la aplicación y obtener el separador de la ruta para la generación de los reportes
 * y para mostrar mensajes en pantallas enviados desde el controlador.	
 * @author Indra
 */ 
@Component
@ApplicationScope
public class AbstractController { 
	
	/** The message source. */
	@Autowired
    private MessageSource messageSource;
	
	/** The context. */
	@Autowired
	private ServletContext context;
	
	
	/** The environment. */
	@Autowired
	protected Environment environment;

    /**
     * Vermsj.
     *
     * @return true, if successful
     */
    @ModelAttribute("rendermessage")
    public boolean vermsj() {
        return false;
    }
    
    /**
     * Typemesaje.
     *
     * @return the string
     */
    @ModelAttribute("typemessage")
    public String typemesaje(){
        return "";
    }
    
    /**
     * Message.
     *
     * @return the string
     */
    @ModelAttribute("message")
    public String message(){
        return "";
    }
    
    /**
     * <p>Obtiene el valor de la propiedad en el archivo messange.properties, y define los parametros que 
     * utiliza la propiedad si es el caso.</p> 
     *
     * @param key the key
     * @param parametros the parametros
     * @return the message
     */
    public String getMessage(String key, String... parametros) {
    	return messageSource.getMessage(key, parametros, Locale.getDefault());
    }
    
    /**
     *<p>Obtiene el separador de ruta para el contexto definido para los reportes. Ej: "/"</p>
     *
     * @return the ruta reporte
     */
    public String getRutaReporte() {
    	return context.getRealPath("/");
    }
    
    /**
     *<p>Obtiene el separador de ruta para el contexto definido para el servidor. Ej: "/"</p>
     *
     * @return the ruta servidor
     */
    public String getRutaServidor() {
    	return context.getRealPath("/");
    }
    
}