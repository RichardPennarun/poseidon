package com.poseidon.webapp.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.poseidon.webapp.config.CustomProperties;
import com.poseidon.webapp.model.CurvePoint;

@Component
public class CurvePointProxy {

	@Autowired
	private CustomProperties props;

	public Iterable<CurvePoint> getCurvePoints() {

		String baseApiUrl = props.getApiUrl();
		String getCurvePointsUrl = baseApiUrl + "/curvePoints";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<CurvePoint>> response = restTemplate.exchange(
				getCurvePointsUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<CurvePoint>>() {}
			);
		
		//log.debug("Get CurvePoints call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public CurvePoint getCurvePoint(int id) {
		String baseApiUrl = props.getApiUrl();
		String getCurvePointUrl = baseApiUrl + "/curvePoint/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CurvePoint> response = restTemplate.exchange(
				getCurvePointUrl, 
				HttpMethod.GET, 
				null,
				CurvePoint.class
			);
		
		//log.debug("Get CurvePoint call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public CurvePoint createCurvePoint(CurvePoint e) {
		String baseApiUrl = props.getApiUrl();
		String createCurvePointUrl = baseApiUrl + "/curvePoint";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<CurvePoint> request = new HttpEntity<CurvePoint>(e);
		ResponseEntity<CurvePoint> response = restTemplate.exchange(
				createCurvePointUrl, 
				HttpMethod.POST, 
				request, 
				CurvePoint.class);
		
		//log.debug("Create CurvePoint call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public CurvePoint updateCurvePoint(CurvePoint e) {
		String baseApiUrl = props.getApiUrl();
		String updateCurvePointUrl = baseApiUrl + "/curvePoint/" + e.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<CurvePoint> request = new HttpEntity<CurvePoint>(e);
		ResponseEntity<CurvePoint> response = restTemplate.exchange(
				updateCurvePointUrl, 
				HttpMethod.PUT, 
				request, 
				CurvePoint.class);
		
		//log.debug("Update CurvePoint call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public void deleteCurvePoint(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteCurvePointUrl = baseApiUrl + "/curvePoint/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteCurvePointUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		//log.debug("Delete CurvePoint call " + response.getStatusCode().toString());
	}

}