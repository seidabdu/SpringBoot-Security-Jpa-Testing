package com.ally.exercise.springbootserurityjpatesting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(HelloController.class);

	@Autowired
	public Environment env;

	@GetMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
	public String hello() {
		String message = env.getProperty("message.error.custom");
		    System.out.println("Here is Prop message-->" + message);
		    LOGGER.trace("doStuff needed more information - {}", message);
	        LOGGER.debug("doStuff needed to debug - {}", message);
	        LOGGER.info("doStuff took input - {}", message);
	        LOGGER.warn("doStuff needed to warn - {}", message);
	        LOGGER.error("doStuff encountered an error with value - {}", message);

		return "hello world";

	}

}
