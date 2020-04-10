package com.cidenet.hulk.store.gateway.zuul.server;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class HulkStoreGatewayZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HulkStoreGatewayZuulServerApplication.class, args);
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		System.out.println("Configurando CORS desde zuul gateway...");
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200")); // <-- you may change "*"
		configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
		configuration.setAllowCredentials(true);
		configuration.setAllowedHeaders(
				Arrays.asList("Accept", "Origin", "Content-Type", "Depth", "User-Agent", "If-Modified-Since,",
						"Cache-Control", "Authorization", "X-Req", "X-File-Size", "X-Requested-With", "X-File-Name"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
