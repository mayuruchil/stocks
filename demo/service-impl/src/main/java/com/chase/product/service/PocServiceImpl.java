package com.chase.product.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.chase.product.model.Stock;
import com.chase.product.service.AppConstants.Exchange;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import exception.ForbiddenException;

@Service
public class PocServiceImpl implements PocService{
	
	private static final Logger logger = LoggerFactory.getLogger(PocServiceImpl.class);
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Async("threadPoolTaskExecutor")
	public CompletableFuture<Stock> getStockValues(String stockExchangeName, String entity, String subEntity) throws ForbiddenException{
		
		// kafkaTemplate.send("test", "customKey","customValue");
		String url = null;
		
		Exchange stockExchange  = AppConstants.Exchange.valueOf(stockExchangeName);
		url = "http://" + stockExchange.registeredServiceName + "/secure/details/jpmc/cards";
		
		Stock stock = restTemplate.getForObject(url, Stock.class);
		return CompletableFuture.completedFuture(stock);
	}

}
