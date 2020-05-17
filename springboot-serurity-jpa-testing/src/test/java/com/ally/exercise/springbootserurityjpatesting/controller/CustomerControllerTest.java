package com.ally.exercise.springbootserurityjpatesting.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import ch.qos.logback.classic.net.SyslogAppender;

import com.ally.exercise.springbootserurityjpatesting.model.Customer;
import com.ally.exercise.springbootserurityjpatesting.repository.CustomerRepository;
import com.ally.exercise.springbootserurityjpatesting.service.JwtUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest extends AbstractMvcTest {

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
	public void testGetCustomers() throws Exception {
		
		final String token = extractToken(login("seid", "seid").andReturn());

		MvcResult result = mockMvc
				.perform(
						get("/get/customers")
								.header("Authorization", "Bearer " + token))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print()).andReturn();

		System.out.println(result.getResponse().getContentAsString());
//		assertEquals("hellow world", result.getResponse().getContentAsString());
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		headers.add("Authorization", "Bearer " + token);
//		
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
		ResponseEntity<List<Customer>> response = restTemplate.exchange(
				createURLWithPort("/get/customers"), HttpMethod.GET,
				entity, new ParameterizedTypeReference<List<Customer>>() {
				});

		// String actual =
		// response.getHeaders().get(HttpHeaders.LOCATION).get(0);

		System.out
				.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(response.getBody());
		response.getBody().forEach( a-> System.out.println(a.getCity()+"\n"));

		// assertTrue(actual.contains("/ally/hello"));
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
