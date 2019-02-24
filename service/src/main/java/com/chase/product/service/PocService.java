package com.chase.product.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.client.RestTemplate;

import com.chase.product.model.Stock;

import exception.ForbiddenException;

public interface PocService {
	public CompletableFuture<Stock> getStockValues(String stockExchangeName, String entity, String subEntity) throws ForbiddenException;

}
