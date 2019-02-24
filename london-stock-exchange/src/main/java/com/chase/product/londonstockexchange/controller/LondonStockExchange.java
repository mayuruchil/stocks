package com.chase.product.londonstockexchange.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chase.product.model.Stock;

@RestController
@RequestMapping(value="/secure")
public class LondonStockExchange {
	
	private static final Logger logger = LoggerFactory.getLogger(LondonStockExchange.class);
	
	@Async
	@SuppressWarnings("finally")
	@RequestMapping("/details/{entity}/{subEntity}")
	public Stock getDetails(@PathVariable("entity") String entity, 
			@PathVariable("subEntity") String subEntity){
		
		logger.info("entity" + entity);
		logger.info("subEntity" + subEntity);
		
		try {
			Thread.currentThread().sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			return new Stock(1, "jpmc", "London Stock Exchange", new BigDecimal(100.032), new Date());	
		}
	}
	
	/*@Async
	@SuppressWarnings("finally")
	@RequestMapping("/details/{entity}/{subEntity}")
	public CompletableFuture<Stock> getDetails(@PathVariable("entity") String entity, 
			@PathVariable("subEntity") String subEntity){
		
		logger.info("entity" + entity);
		logger.info("subEntity" + subEntity);
		
		try {
			Thread.currentThread().sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			return CompletableFuture.completedFuture(new Stock(1, "jpmc", "London Stock Exchange", new BigDecimal(100.032), new Date()));	
		}
	}*/

}
