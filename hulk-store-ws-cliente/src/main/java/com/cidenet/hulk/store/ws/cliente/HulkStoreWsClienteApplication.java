package com.cidenet.hulk.store.ws.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.cidenet.hulk.store.model.entity"})
@SpringBootApplication
public class HulkStoreWsClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreWsClienteApplication.class, args);
	}
	

}
