package com.cidenet.hulk.store.ws.cliente.repository.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.internal.SessionImpl;
import org.springframework.stereotype.Repository;

import com.cidenet.hulk.store.ws.cliente.repository.JasperRepository;

@Repository
public class JasperRepositoyImpl implements JasperRepository{
	
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public Connection connectionEntity() throws SQLException {
        return entityManager.unwrap(SessionImpl.class).connection();
    }

}
