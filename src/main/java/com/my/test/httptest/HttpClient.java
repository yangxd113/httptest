package com.my.test.httptest;
import org.springframework.http.*; 
import org.springframework.http.client.ClientHttpResponse; 
import org.springframework.util.MultiValueMap; 
import org.springframework.web.client.ResponseErrorHandler; 
import org.springframework.web.client.RestTemplate;


public class HttpClient {

	public static String sendGetRequest(String url, MultiValueMap<String, String> params,HttpHeaders headers)
	
	{
	  RestTemplate client = new RestTemplate(); 
	  HttpMethod method = HttpMethod.GET; 
	  headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED); 
	  HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers); 
	  ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class); 
	  return response.getBody(); 
	 }
}


