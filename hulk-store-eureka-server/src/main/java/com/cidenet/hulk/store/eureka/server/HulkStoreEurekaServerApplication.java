package com.cidenet.hulk.store.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HulkStoreEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreEurekaServerApplication.class, args);
	}

}
