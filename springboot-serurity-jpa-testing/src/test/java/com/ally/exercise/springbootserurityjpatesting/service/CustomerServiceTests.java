package com.ally.exercise.springbootserurityjpatesting.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ally.exercise.springbootserurityjpatesting.model.Customer;
import com.ally.exercise.springbootserurityjpatesting.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerServiceTests {

	@MockBean
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerService customerService;

	@Test
	public void testGetCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		Customer cust1 = new Customer();
		cust1.setCity("Mekelle");
		Customer cust2 = new Customer();
		cust2.setCity("Adigrat");
		customerList.add(cust1);
		customerList.add(cust2);

		when(customerRepository.findAll()).thenReturn(customerList);

		List<Customer> result = customerService.getAllCustomers();
		assertEquals(2, result.size());
	}

	@Test
	public void testFindByContactName() {

		Customer cust1 = new Customer();
		cust1.setCity("Mekelle");

		when(customerRepository.findByContactName(Mockito.anyString()))
				.thenReturn(cust1);

		Customer result = customerService
				.findByContactName(Mockito.anyString());
		assertEquals(result.getCity(), "Mekelle");
	}

	@Test
	public void testFindByConmpany() {

		Customer cust1 = new Customer();
		cust1.setCity("Mekelle");
		cust1.setCompanyName("AIG");

		when(customerRepository.findByCompanyName(Mockito.anyString()))
				.thenReturn(cust1);

		Customer result = customerService
				.findByCompanyName(Mockito.anyString());
		assertEquals(result.getCompanyName(), "AIG");
	}

	@Test
	public void testAddCustomer() {

		Customer cust1 = new Customer();
		cust1.setCity("Mekelle");
		cust1.setCompanyName("AIG");

		when(customerRepository.save(Mockito.anyObject())).thenReturn(cust1);

		Customer result = customerService.addCustomer(cust1);
		assertNotNull(result);
	}

}
