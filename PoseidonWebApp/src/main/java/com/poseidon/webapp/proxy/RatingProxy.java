package com.poseidon.webapp.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.poseidon.webapp.config.CustomProperties;
import com.poseidon.webapp.model.Rating;

@Component
public class RatingProxy {

	@Autowired
	private CustomProperties props;

	public Iterable<Rating> getRatings() {

		String baseApiUrl = props.getApiUrl();
		String getRatingsUrl = baseApiUrl + "/ratings";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Rating>> response = restTemplate.exchange(
				getRatingsUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Rating>>() {}
			);
		
		return response.getBody();
	}
	
	public Rating getRating(int id) {
		String baseApiUrl = props.getApiUrl();
		String getRatingUrl = baseApiUrl + "/rating/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Rating> response = restTemplate.exchange(
				getRatingUrl, 
				HttpMethod.GET, 
				null,
				Rating.class
			);
		
		return response.getBody();
	}
	
	public Rating createRating(Rating e) {
		String baseApiUrl = props.getApiUrl();
		String createRatingUrl = baseApiUrl + "/rating";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Rating> request = new HttpEntity<Rating>(e);
		ResponseEntity<Rating> response = restTemplate.exchange(
				createRatingUrl, 
				HttpMethod.POST, 
				request, 
				Rating.class);
		
		return response.getBody();
	}
	
	public Rating updateRating(Rating e) {
		String baseApiUrl = props.getApiUrl();
		String updateRatingUrl = baseApiUrl + "/rating/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Rating> request = new HttpEntity<Rating>(e);
		ResponseEntity<Rating> response = restTemplate.exchange(
				updateRatingUrl, 
				HttpMethod.PUT, 
				request, 
				Rating.class);
		
		return response.getBody();
	}
	
	public void deleteRating(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteRatingUrl = baseApiUrl + "/rating/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteRatingUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
	}

}