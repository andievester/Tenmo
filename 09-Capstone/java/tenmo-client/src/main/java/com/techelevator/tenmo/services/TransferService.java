package com.techelevator.tenmo.services;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Random;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import com.techelevator.tenmo.models.Transfer;
import com.techelevator.tenmo.models.User;

public class TransferService {

	private final String BASE_SERVICE_URL;
	private RestTemplate restTemplate = new RestTemplate();
	
	public TransferService(String baseUrl) {
		this.BASE_SERVICE_URL = baseUrl + "transfer/";
	}

	private HttpHeaders authHeaders(String authToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(authToken);
		return headers;
	}
	
	 public Transfer doTransfer(String CSV) {
		  
		  HttpHeaders headers = new HttpHeaders();
		  headers.setContentType(MediaType.APPLICATION_JSON);
		  Transfer transfer = makeTransfer(CSV);
		  HttpEntity<Transfer> entity = new HttpEntity<Transfer>(headers);

		  try {
		  transfer = restTemplate.postForObject(BASE_SERVICE_URL,entity,Transfer.class);
		  }
		  catch (RestClientResponseException e) {
		  }	  
		  return transfer;
	  }

	 private Transfer makeTransfer(String CSV) {
		    String[] parsed = CSV.split(",");   
		    return new Transfer(parsed[0],parsed[1],parsed[2]);
	 }
}
