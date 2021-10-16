package com.poseidon.webapp.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.poseidon.webapp.config.CustomProperties;
import com.poseidon.webapp.model.Trade;

@Component
public class TradeProxy {

	@Autowired
	private CustomProperties props;

	public Iterable<Trade> getTrades() {

		String baseApiUrl = props.getApiUrl();
		String getTradesUrl = baseApiUrl + "/trades";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Trade>> response = restTemplate.exchange(
				getTradesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Trade>>() {}
			);
		
		//log.debug("Get Trades call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Trade getTrade(int id) {
		String baseApiUrl = props.getApiUrl();
		String getTradeUrl = baseApiUrl + "/trade/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Trade> response = restTemplate.exchange(
				getTradeUrl, 
				HttpMethod.GET, 
				null,
				Trade.class
			);
		
		//log.debug("Get Trade call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Trade createTrade(Trade e) {
		String baseApiUrl = props.getApiUrl();
		String createTradeUrl = baseApiUrl + "/trade";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Trade> request = new HttpEntity<Trade>(e);
		ResponseEntity<Trade> response = restTemplate.exchange(
				createTradeUrl, 
				HttpMethod.POST, 
				request, 
				Trade.class);
		
		//log.debug("Create Trade call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Trade updateTrade(Trade e) {
		String baseApiUrl = props.getApiUrl();
		String updateTradeUrl = baseApiUrl + "/trade/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Trade> request = new HttpEntity<Trade>(e);
		ResponseEntity<Trade> response = restTemplate.exchange(
				updateTradeUrl, 
				HttpMethod.PUT, 
				request, 
				Trade.class);
		
		//log.debug("Update Trade call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public void deleteTrade(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteTradeUrl = baseApiUrl + "/trade/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteTradeUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		//log.debug("Delete Trade call " + response.getStatusCode().toString());
	}

}