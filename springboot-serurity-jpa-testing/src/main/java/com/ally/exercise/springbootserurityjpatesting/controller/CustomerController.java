package com.ally.exercise.springbootserurityjpatesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ally.exercise.springbootserurityjpatesting.model.Customer;
import com.ally.exercise.springbootserurityjpatesting.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	public CustomerService customerService;

	@RequestMapping(value = "/get/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getCustomer() {

		// System.out.println(jsonProperties.getHost());
		List<Customer> customers = customerService.getAllCustomers();
		System.out.println(customers.size());
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@RequestMapping(value = "/get/contactname/{contactName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerByContactName(
			@PathVariable("contactName") String contactName) {
		Customer customer = customerService.findByContactName(contactName);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/get/companyname/{companyName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerByCompanyName(
			@PathVariable("companyName") String companyName) {
		Customer customer = customerService.findByCompanyName(companyName);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/add/customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer cust = customerService.addCustomer(customer);
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}

}
