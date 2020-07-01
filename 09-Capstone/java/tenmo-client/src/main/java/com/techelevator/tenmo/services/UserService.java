package com.techelevator.tenmo.services;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.techelevator.tenmo.models.User;

public class UserService {

	private final String BASE_SERVICE_URL;
	private RestTemplate restTemplate = new RestTemplate();
	
	public UserService(String baseUrl) {
		this.BASE_SERVICE_URL = baseUrl + "user/";
	}
	
	public User[] list(String authToken){
		HttpEntity<?> headerStuff = new HttpEntity<>(authHeaders(authToken));
		ResponseEntity<User[]> response = restTemplate.exchange(BASE_SERVICE_URL, HttpMethod.GET, headerStuff,User[].class);
		return response.getBody();
	}

	private HttpHeaders authHeaders(String authToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(authToken);
		return headers;
	}

}
