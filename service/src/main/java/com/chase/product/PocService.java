package com.chase.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import exception.ForbiddenException;

// @Service
public class PocService {
	
	/*@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String getService(RestTemplate restTemplate, String name) throws ForbiddenException{
		
		// kafkaTemplate.send("test", "khikhi","HelloRozie");
		String url = "http://london-stock-exchange/secure/details/jpmc/cards";
		return restTemplate.getForObject(url, String.class);
	}
*/
}
