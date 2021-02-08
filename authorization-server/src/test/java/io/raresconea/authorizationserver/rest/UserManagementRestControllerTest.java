package io.raresconea.authorizationserver.rest;

import io.raresconea.authorizationserver.security.WithCustomUser;
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
	@WithCustomUser(authority = "ROLE_USER")
	public void test2() throws Exception {
		mockMvc.perform(get("/users/me"))
				.andExpect(status().isOk());
	}

}
