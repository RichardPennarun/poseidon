package com.poseidon.webapp.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.poseidon.webapp.config.CustomProperties;
import com.poseidon.webapp.model.User;

@Component
public class UserProxy {

	@Autowired
	private CustomProperties props;

	
	// Get a user by its username (authentication)
	public User findByUsername(String username) {
		String baseApiUrl = props.getApiUrl();
		String getUserUrl = baseApiUrl + "/user/" + username;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> response = restTemplate.exchange(getUserUrl, HttpMethod.GET, null, User.class);
		return response.getBody();
	}

	
	public Iterable<User> getUsers() {

		String baseApiUrl = props.getApiUrl();
		String getUsersUrl = baseApiUrl + "/users";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<User>> response = restTemplate.exchange(
				getUsersUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<User>>() {}
			);
		
		return response.getBody();
	}
	
	
	public User getUser(int id) {
		String baseApiUrl = props.getApiUrl();
		String getUserUrl = baseApiUrl + "/user/id/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> response = restTemplate.exchange(
				getUserUrl, 
				HttpMethod.GET, 
				null,
				User.class
			);
		
		return response.getBody();
	}
	
	public User createUser(User e) {
		String baseApiUrl = props.getApiUrl();
		String createUserUrl = baseApiUrl + "/user";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<User> request = new HttpEntity<User>(e);
		ResponseEntity<User> response = restTemplate.exchange(
				createUserUrl, 
				HttpMethod.POST, 
				request, 
				User.class);
		
		return response.getBody();
	}
	
	public User updateUser(User e) {
		String baseApiUrl = props.getApiUrl();
		String updateUserUrl = baseApiUrl + "/user/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<User> request = new HttpEntity<User>(e);
		ResponseEntity<User> response = restTemplate.exchange(
				updateUserUrl, 
				HttpMethod.PUT, 
				request, 
				User.class);
		
		return response.getBody();
	}
	
	public void deleteUser(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteUserUrl = baseApiUrl + "/user/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteUserUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);

	}

}