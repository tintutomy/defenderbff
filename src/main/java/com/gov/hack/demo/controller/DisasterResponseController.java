package com.gov.hack.demo.controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gov.hack.demo.dao.VolunteerRepository;
import com.gov.hack.demo.model.VolunteerProfile;
import org.springframework.boot.jackson.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;


@RestController
public class DisasterResponseController {
	//one event for registration
	// event for sending the message - (send message to people under category message)
	@Autowired
	private VolunteerRepository repository;
	@PostMapping("/saveVolunteerDetails")
	public String saveVoluteerDetails(@RequestBody VolunteerProfile volunteerProfile)
	{
		
		repository.save(volunteerProfile);
		return "Volunteer Information saved";
	}
	@GetMapping("/getAllVoluteerInfo")
	public List<VolunteerProfile> getAll()
	{
		return repository.findAll();
		 
	}
	@GetMapping("/getAllVoluteersByCategory")
	public List<VolunteerProfile> getVolunteerByCategory(@PathVariable String category)
	{
		return repository.findByCategory(category);
		 
	}
	@PostMapping("/broadcastMessage")
	public boolean broadcastMessage(@RequestBody String message)
	{
//		JSONObject oAuthRequest = new JSONObject();
//		oAuthRequest.put("client_id","jwfkiBnHFiHzgrdRKm1lz7Io7HYQD8bw");
//		oAuthRequest.put("client_secret","sfZeBbGnEfBnlOFL");
//		oAuthRequest.put("grant_type","client_credentials");
//		oAuthRequest.put("scope","NSMS");
//		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
//		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.165.128.194", 80));
//		clientHttpRequestFactory.setProxy(proxy);
//		System.out.println(oAuthRequest);
//		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
//	//	String response = restTemplate.postForObject("https://tapi.telstra.com/v2/oauth/token", oAuthRequest, String.class);
//
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		System.out.println("Hello");
//		System.out.print(response);

//	//	showsDTO = objectMapper.readValue(response.toString(), new TypeReference<List<ShowsDTO>>() {
//	//	});
		// request url
		String url = "https://tapi.telstra.com/v2/oauth/token";

		// create an instance of RestTemplate
		RestTemplate restTemplateResponse = new RestTemplate();

		// create headers
		HttpHeaders headers = new HttpHeaders();
		// set `content-type` header
		//headers.setContentType(MediaType.);
		// set `accept` header
		//headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		// request body parameters
//		Map<String, Object> oAuthRequest = new HashMap<>();
//		oAuthRequest.put("client_id","jwfkiBnHFiHzgrdRKm1lz7Io7HYQD8bw");
//		oAuthRequest.put("client_secret","sfZeBbGnEfBnlOFL");
//		oAuthRequest.put("grant_type","client_credentials");
//		oAuthRequest.put("scope","NSMS");
		JSONObject oAuthRequest = new JSONObject();
		oAuthRequest.put("client_id","jwfkiBnHFiHzgrdRKm1lz7Io7HYQD8bw");
		oAuthRequest.put("client_secret","sfZeBbGnEfBnlOFL");
		oAuthRequest.put("grant_type","client_credentials");
		oAuthRequest.put("scope","NSMS");

		// build the request
		HttpEntity<JSONObject> entity = new HttpEntity<>(oAuthRequest, headers);

		// send POST request
		ResponseEntity<String> response1 = restTemplateResponse.postForEntity(url, entity, String.class);

		// check response
		if (response1.getStatusCode() == HttpStatus.CREATED) {
		    System.out.println("Request Successful");
		    System.out.println(response1.getBody());
		} else {
		    System.out.println("Request Failed");
		    System.out.println(response1.getStatusCode());
		}  
return true;
		
		
		 
	}
//	public List<ShowsDTO> getCarShowDetails() throws URISyntaxException {
//		LOGGER.debug("Inside getCarShowDetails");
//		List<ShowsDTO> showsDTO = null;
//		try {
//
//			SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
//			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.165.128.194", 80));
//			clientHttpRequestFactory.setProxy(proxy);
//			RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
//			String response = restTemplate
//					.getForObject("http://eacodingtest.digital.energyaustralia.com.au/api/v1/cars", String.class);
//
//			LOGGER.info("response in string:{}", response.toString());
//
//			ObjectMapper objectMapper = new ObjectMapper();
//
//			showsDTO = objectMapper.readValue(response.toString(), new TypeReference<List<ShowsDTO>>() {
//			});
//			LOGGER.info("showsDTO {}", showsDTO);
//		} catch (JsonParseException e) {
//			LOGGER.error("JsonParseException in getCarShowDetails : {}", e);
//		} catch (JsonMappingException e) {
//			LOGGER.error("JsonMappingException in getCarShowDetails : {}", e);
//		} catch (IOException e) {
//			LOGGER.error("IOException in getCarShowDetails : {}", e);
//		} catch (Exception e) {
//			LOGGER.error("Exception in getCarShowDetails : {}", e);
//		}
//
//		if (showsDTO != null && !showsDTO.isEmpty()) {
//			return showsDTO;
//		} else {
//			return null;
//		}
//	}
//
//	
	

}
