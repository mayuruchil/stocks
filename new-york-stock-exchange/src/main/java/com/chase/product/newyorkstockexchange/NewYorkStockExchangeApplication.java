package com.chase.product.newyorkstockexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class NewYorkStockExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewYorkStockExchangeApplication.class, args);
	}

}
