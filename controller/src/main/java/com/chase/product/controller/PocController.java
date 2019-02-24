package com.chase.product.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.chase.product.config.AppConstants;
import com.chase.product.config.AppConstants.Exchange;
import com.chase.product.model.Stock;
import com.chase.product.service.PocServiceImpl;

import exception.BadDataException;
import exception.ForbiddenException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/stock")
@EnableAsync(proxyTargetClass=true)
public class PocController extends Publisher{
	
	private static final Logger logger = LoggerFactory.getLogger(PocController.class);

   @Autowired
   PocServiceImpl service;
   
   @Autowired
   RestTemplate restTemplate;
   
   @RequestMapping(value = "/values", method=GET)
    public void publish(@RequestParam(value="entity", defaultValue="jpmc") String entity, 
    		@RequestParam(value="subEntity", defaultValue="chase") String subEntity) throws ForbiddenException {
    	logger.info("Inside publish method -Entity = " + entity + " SubEntity = " + subEntity);
    	
        long start = System.currentTimeMillis();
        
        try {
        	
        AppConstants.Exchange[] services = AppConstants.Exchange.values();         	
       int noOfExchanges = services.length;
        CompletableFuture<Stock> stocks[] = new CompletableFuture[noOfExchanges];
        int i = 0;
        for (Exchange api : services) {
        	stocks[i] = service.getStockValues(api.getCountryName(), entity,subEntity);
        	i++;
        }
        
        /*for(int i = 0; i < noOfExchanges; i++){
        	stocks[i] = service.getStockValues(exchanges[i], entity, subEntity);
        }*/
    	// CompletableFuture<Stock> lseStock = service.getStockValues("lseStock", entity, subEntity);
    	// CompletableFuture<Stock> nyseStock = service.getStockValues("nyseStock", entity, subEntity);
    	// CompletableFuture<Stock> nseStock = service.getStockValues("nseStock", entity, subEntity);
    	// CompletableFuture.allOf(lseStock,nyseStock,nseStock).join();
    	CompletableFuture.allOf(stocks).join();
    	for(int j = 0; j < noOfExchanges; j++){
    		publishToKafka(stocks[j].get());
        }
        // publishToKafka(lseStock.get());
    	// publishToKafka(nyseStock.get());
    	// publishToKafka(nseStock.get());
    	logger.info("Elapsed time: " + (System.currentTimeMillis() - start));	
    	}
    	catch (InterruptedException | ExecutionException e1) {
			logger.error(e1.getMessage());
		}
    }
    
    @ExceptionHandler
    void handleBadDataException(BadDataException e, HttpServletResponse response) throws IOException {
    	logger.error("BadData Exception" + e.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(),"BadData");
    }
    
    @ExceptionHandler
    void handleForbiddenAccessException(ForbiddenException e, HttpServletResponse response) throws IOException {
    	logger.error("ForbiddenException exception" + e.getMessage());
        response.sendError(HttpStatus.BAD_REQUEST.value(),"Foridden");
    }
    
}
