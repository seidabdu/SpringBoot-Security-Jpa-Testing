/*package com.ally.exercise.springbootserurityjpatesting.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

public class AuthenticationTest extends AbstractMvcTest {
	@Override
	protected void doInit() throws Exception {
		registerUser("julia", "julia").andExpect(status().isCreated());
	}

	@Test
	public void userRepositoryWithoutTokenIsForbidden() throws Exception {
		mockMvc.perform(get("/api/users")).andExpect(status().isForbidden());
	}

	@Test
	public void userRepositoryWithTokenIsAllowed() throws Exception {
		final String token = extractToken(login("name", "pass").andReturn());
		mockMvc.perform(
				get("/api/users").header("Authorization", "Bearer " + token))
				.andExpect(status().isOk());
	}

	@Test
	public void loginOk() throws Exception {
		login("name", "pass").andExpect(status().isOk())
				.andExpect(jsonPath("$.token").exists())
				.andExpect(jsonPath("$.user.username", equalTo("name")))
				.andExpect(jsonPath("$.user.password").doesNotExist())
				.andReturn();
	}

	@Test
	public void loginNok() throws Exception {
		login("name", "wrong").andExpect(status().isForbidden());
	}

	private ResultActions registerUser(String username, String password)
			throws Exception {
		return mockMvc.perform(post("/api/users").content(
				"{\"username\":\"" + username + "\",\"password\":\"" + password
						+ "\"}"));
	}
}
*/