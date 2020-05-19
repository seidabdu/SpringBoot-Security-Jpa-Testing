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

import com.ally.exercise.springbootserurityjpatesting.exception.ResourceNotFoundException;
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
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@RequestMapping(value = "/get/contactname/{contactName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerByContactName(
			@PathVariable("contactName") String contactName) throws ResourceNotFoundException {
		Customer customer = customerService.findByContactName(contactName);

		if (null == customer) {
			throw new ResourceNotFoundException("Resource not found");
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/get/companyname/{companyName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomerByCompanyName(
			@PathVariable("companyName") String companyName) throws ResourceNotFoundException {
		Customer customer = customerService.findByCompanyName(companyName);

		if (null == customer) {
			throw new ResourceNotFoundException("Resource not found");
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/add/customer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

		System.out.println("Customer Contact Name-->"
				+ customer.getContactName());
		Customer cust = customerService.addCustomer(customer);
		return new ResponseEntity<>(cust, HttpStatus.OK);
	}

}
