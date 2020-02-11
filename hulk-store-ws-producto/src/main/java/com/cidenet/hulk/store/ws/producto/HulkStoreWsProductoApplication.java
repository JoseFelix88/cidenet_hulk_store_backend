package com.cidenet.hulk.store.ws.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.cidenet.hulk.store.model.entity"})
@SpringBootApplication
public class HulkStoreWsProductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreWsProductoApplication.class, args);
	}

}
