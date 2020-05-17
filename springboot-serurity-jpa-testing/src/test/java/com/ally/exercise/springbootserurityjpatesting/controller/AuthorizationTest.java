package com.ally.exercise.springbootserurityjpatesting.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.ally.exercise.springbootserurityjpatesting.repository.CustomerRepository;
import com.ally.exercise.springbootserurityjpatesting.service.JwtUserDetailsService;

public class AuthorizationTest extends AbstractMvcTest {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private JwtUserDetailsService JwtUserDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private static String companyAid, companyBid;

	public void doInit() throws Exception {
		// final Customer customerA = new Customer();
		// customerA.setCity("Charlotte");
		// companyAid = customerRepository.save(customerA).getCompanyName();
		//
		// final Customer customerB = new Customer();
		// customerB.setCity("Mekelle");
		// companyBid = customerRepository.save(customerB).getCompanyName();

		// final UserDTO user = new UserDTO();
		// user.setUsername("america");
		// user.setPassword(passwordEncoder.encode("america"));
		// user.setRoles(Arrays.asList("ROLE_USER"));
		// user.setCompany(companyA);
		// JwtUserDetailsService.save(user);

		// final UserDTO admin = new UserDTO();
		// admin.setUsername("seid");
		// admin.setPassword(passwordEncoder.encode("seid"));
		// admin.setRoles(Arrays.asList("ROLE_ADMIN"));
		// admin.setCompany(companyB);
		// JwtUserDetailsService.save(admin);
	}

	@Test
	public void userCannotAccessListOfCompanies() throws Exception {
		final String token = extractToken(login("seid", "seid").andReturn());

		MvcResult result = mockMvc
				.perform(
						get("/hello")
								.header("Authorization", "Bearer " + token))
				.andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print()).andReturn();

		System.out.println(result.getResponse().getContentAsString());
		assertEquals("hellow world", result.getResponse().getContentAsString());
	}

	// @Test
	// public void adminCanAccessListOfCompanies() throws Exception {
	// final String token = extractToken(login("admin", "pass").andReturn());
	// mockMvc.perform(
	// get("/api/companies")
	// .header("Authorization", "Bearer " + token)).andExpect(
	// status().isOk());
	// }
	//
	// @Test
	// public void userCanAccessOwnCompany() throws Exception {
	// final String token = extractToken(login("user", "pass").andReturn());
	// mockMvc.perform(
	// get("/api/companies/" + companyAid).header("Authorization",
	// "Bearer " + token)).andExpect(status().isOk());
	// }
	//
	// @Test
	// public void userCannotAccessForeignCompany() throws Exception {
	// final String token = extractToken(login("user", "pass").andReturn());
	// mockMvc.perform(
	// get("/api/companies/" + companyBid).header("Authorization",
	// "Bearer " + token)).andExpect(status().isForbidden());
	// }
	//
	// @Test
	// public void userCannotAccessForeignCompanyViaUser() throws Exception {
	// final String token = extractToken(login("user", "pass").andReturn());
	// final MvcResult authorization = mockMvc.perform(
	// get("/api/users/search/findByUsername?username=admin").header(
	// "Authorization", "Bearer " + token)).andReturn();
	// final String c = JsonPath.read(authorization.getResponse()
	// .getContentAsString(), "$._links.company.href");
	//
	// mockMvc.perform(get(c).header("Authorization", "Bearer " + token))
	// .andExpect(status().isForbidden());
	// }
	//
	// @Test
	// public void adminCanAccessOwnCompany() throws Exception {
	// final String token = extractToken(login("admin", "pass").andReturn());
	// mockMvc.perform(
	// get("/api/companies/" + companyAid).header("Authorization",
	// "Bearer " + token)).andExpect(status().isOk());
	// }
	//
	// @Test
	// public void adminCanAccessForeignCompany() throws Exception {
	// final String token = extractToken(login("admin", "pass").andReturn());
	// mockMvc.perform(
	// get("/api/companies/" + companyBid).header("Authorization",
	// "Bearer " + token)).andExpect(status().isOk());
	// }

}
