package com.poseidon.webapp.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.poseidon.webapp.config.CustomProperties;
import com.poseidon.webapp.model.Bid;

@Component
public class BidProxy {

	@Autowired
	private CustomProperties props;

	public Iterable<Bid> getBids() {

		String baseApiUrl = props.getApiUrl();
		String getBidsUrl = baseApiUrl + "/bids";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Bid>> response = restTemplate.exchange(
				getBidsUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Bid>>() {}
			);
		
		//log.debug("Get BidLists call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Bid getBid(int id) {
		String baseApiUrl = props.getApiUrl();
		String getBidUrl = baseApiUrl + "/bid/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Bid> response = restTemplate.exchange(
				getBidUrl, 
				HttpMethod.GET, 
				null,
				Bid.class
			);
		
		//log.debug("Get BidList call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Bid createBid(Bid e) {
		String baseApiUrl = props.getApiUrl();
		String createBidUrl = baseApiUrl + "/bid";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Bid> request = new HttpEntity<Bid>(e);
		ResponseEntity<Bid> response = restTemplate.exchange(
				createBidUrl, 
				HttpMethod.POST, 
				request, 
				Bid.class);
		
		//log.debug("Create BidList call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Bid updateBid(Bid e) {
		String baseApiUrl = props.getApiUrl();
		String updateBidUrl = baseApiUrl + "/bid/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Bid> request = new HttpEntity<Bid>(e);
		ResponseEntity<Bid> response = restTemplate.exchange(
				updateBidUrl, 
				HttpMethod.PUT, 
				request, 
				Bid.class);
		
		//log.debug("Update BidList call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public void deleteBid(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteBidUrl = baseApiUrl + "/bid/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteBidUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		//log.debug("Delete BidList call " + response.getStatusCode().toString());
	}

}