package com.poseidon.webapp.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.poseidon.webapp.config.CustomProperties;
import com.poseidon.webapp.model.Rule;

@Component
public class RuleProxy {

	@Autowired
	private CustomProperties props;

	public Iterable<Rule> getRules() {

		String baseApiUrl = props.getApiUrl();
		String getRulesUrl = baseApiUrl + "/rules";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Rule>> response = restTemplate.exchange(
				getRulesUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Rule>>() {}
			);
		
		return response.getBody();
	}
	
	public Rule getRule(int id) {
		String baseApiUrl = props.getApiUrl();
		String getRuleUrl = baseApiUrl + "/rule/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Rule> response = restTemplate.exchange(
				getRuleUrl, 
				HttpMethod.GET, 
				null,
				Rule.class
			);
		
		return response.getBody();
	}
	
	public Rule createRule(Rule e) {
		String baseApiUrl = props.getApiUrl();
		String createRuleUrl = baseApiUrl + "/rule";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Rule> request = new HttpEntity<Rule>(e);
		ResponseEntity<Rule> response = restTemplate.exchange(
				createRuleUrl, 
				HttpMethod.POST, 
				request, 
				Rule.class);
		
		return response.getBody();
	}
	
	public Rule updateRule(Rule e) {
		String baseApiUrl = props.getApiUrl();
		String updateRuleUrl = baseApiUrl + "/rule/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Rule> request = new HttpEntity<Rule>(e);
		ResponseEntity<Rule> response = restTemplate.exchange(
				updateRuleUrl, 
				HttpMethod.PUT, 
				request, 
				Rule.class);
		
		return response.getBody();
	}
	
	public void deleteRule(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteRuleUrl = baseApiUrl + "/rule/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteRuleUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
	}

}