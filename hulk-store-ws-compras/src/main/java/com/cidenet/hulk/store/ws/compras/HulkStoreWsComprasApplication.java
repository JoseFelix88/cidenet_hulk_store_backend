package com.cidenet.hulk.store.ws.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EntityScan(basePackages = {"com.cidenet.hulk.store.model.entity"})
@SpringBootApplication
public class HulkStoreWsComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreWsComprasApplication.class, args);
	}

}
