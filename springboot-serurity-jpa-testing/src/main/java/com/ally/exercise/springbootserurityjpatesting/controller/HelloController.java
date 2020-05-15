package com.ally.exercise.springbootserurityjpatesting.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value="/hello",produces = MediaType.TEXT_PLAIN_VALUE)
	public String hello() {
		return "hellow world";

	}

}
