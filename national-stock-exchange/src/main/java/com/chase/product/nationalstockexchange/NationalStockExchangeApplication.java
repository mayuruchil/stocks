package com.chase.product.nationalstockexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NationalStockExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NationalStockExchangeApplication.class, args);
	}

}
