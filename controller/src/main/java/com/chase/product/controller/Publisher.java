package com.chase.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chase.product.model.Stock;

public abstract class Publisher {
	private static final Logger logger = LoggerFactory.getLogger(Publisher.class);
	
	// Additional Kafka parameters needs to be added 
	protected  void publishToKafka(Stock stock){
		logger.info(stock.getStockExchangeName() + " published to Kafka Successfully");
	}
}
