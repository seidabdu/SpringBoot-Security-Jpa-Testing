package com.ally.exercise.springbootserurityjpatesting.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestWebServiceConfiguration {

	@Bean
	@Scope("prototype")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();

	}

}
