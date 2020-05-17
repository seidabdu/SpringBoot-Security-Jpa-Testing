package com.ally.exercise.springbootserurityjpatesting.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	private ObjectMapper mapper = new ObjectMapper();

	HttpHeaders headers = new HttpHeaders();
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void testGetHello() throws Exception {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/ally/hello"), HttpMethod.GET, entity,
				String.class);

		// String actual =
		// response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		System.out
				.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(response.getBody());
		System.out
				.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		// assertTrue(actual.contains("/ally/hello"));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
