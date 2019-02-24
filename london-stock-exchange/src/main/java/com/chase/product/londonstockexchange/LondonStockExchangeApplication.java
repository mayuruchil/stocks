package com.chase.product.londonstockexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LondonStockExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LondonStockExchangeApplication.class, args);
	}

}
