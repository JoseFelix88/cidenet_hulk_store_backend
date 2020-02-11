package com.cidenet.hulk.store.ws.ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EntityScan(basePackages = {"com.cidenet.hulk.store.model.entity"})
@SpringBootApplication
public class HulkStoreWsVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreWsVentasApplication.class, args);
	}

}
