package com.cidenet.hulk.store.ws.proveedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.cidenet.hulk.store.model.entity"})
@SpringBootApplication
public class HulkStoreWsProveedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreWsProveedorApplication.class, args);
	}

}
