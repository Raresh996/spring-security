package io.raresconea.authorizationserver.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserManagementRestControllerTest {
	private static final String AUTHENTICATED_ACCESS_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MTUzMjgxNTksInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiJdLCJqdGkiOiJrUDlqbzdqNHJoU3Uwc2JIT2pLaVhvemd1NHMiLCJjbGllbnRfaWQiOiJjbGllbnQiLCJzY29wZSI6WyJ3cml0ZSJdfQ.Zsx1zppXvbqXanxpFLvQ2vWrP6x9THCuz-tAEkmIdAs";

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("WHEN user is not authenticated THEN calling /users/me should return 401 Unauthorized")
	public void test1() throws Exception {
		mockMvc.perform(get("/users/me"))
				.andExpect(status().isUnauthorized());
	}

	@Test
	@DisplayName("WHEN user is authenticated THEN calling /users/me should return 200 OK")
	public void test2() throws Exception {
		mockMvc.perform(get("/users/me")
				.header("Authorization", "Bearer " + AUTHENTICATED_ACCESS_TOKEN))
				.andExpect(status().isOk());
	}

}
