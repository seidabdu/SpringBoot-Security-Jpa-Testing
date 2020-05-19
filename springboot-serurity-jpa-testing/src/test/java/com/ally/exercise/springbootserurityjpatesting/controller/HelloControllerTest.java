package com.ally.exercise.springbootserurityjpatesting.controller;

import static org.junit.Assert.assertEquals;

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

import com.ally.exercise.springbootserurityjpatesting.repository.CustomerRepository;
import com.ally.exercise.springbootserurityjpatesting.service.JwtUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest extends AbstractMvcTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	private ObjectMapper mapper = new ObjectMapper();

	HttpHeaders headers = new HttpHeaders();

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private JwtUserDetailsService JwtUserDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void testGetHello() throws Exception {

		final String token = extractToken(login("seid", "seid").andReturn());
		headers.add("Authorization", "Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/hello"), HttpMethod.GET, entity,
				String.class);

		System.out.println("Body of the response--->" + response.getBody());

		assertEquals("hello world", response.getBody());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
