package com.cidenet.hulk.store.ws.cliente.repository;

import java.sql.Connection;
import java.sql.SQLException;

public interface JasperRepository {
	
    /**
     * @return @throws ICAROException
     */
    Connection connectionEntity() throws SQLException; 


}
