package com.poseidon.webapp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poseidon.webapp.model.User;
import com.poseidon.webapp.proxy.UserProxy;
import com.poseidon.webapp.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserProxy userProxy;

	@MockBean
	private UserService userService;

	@Before
	public void setup() {

	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testGetUserList() throws Exception {

		mockMvc.perform(get("/userList")).andDo(print()).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testAddUserForm() throws Exception {

		User userToSave = new User();
		userToSave.setUsername("a");
		userToSave.setPassword("b");
		userToSave.setFullname("c");
		userToSave.setRole("d");

		mockMvc.perform(get("/createUser").content(asJsonString(userToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	@Disabled
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateAddOk() throws Exception {

		User userToSave = new User();
		userToSave.setUsername("a");
		userToSave.setPassword("b");
		userToSave.setFullname("c");
		userToSave.setRole("d");

		when(userService.saveUser(userToSave)).thenReturn(userToSave);

		mockMvc.perform(post("/validateUserAdd").content(asJsonString(userToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(redirectedUrl("/userList"));
	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testUpdateUser() throws Exception {

		User userToSave = new User();
		userToSave.setId(2);
		userToSave.setUsername("a");
		userToSave.setPassword("b");
		userToSave.setFullname("c");
		userToSave.setRole("d");

		when(userService.getUser(2)).thenReturn(userToSave);

		mockMvc.perform(get("/updateUser/{id}", 2).content(asJsonString(userToSave))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

	@Disabled
	@Test
	@WithMockUser(username = "user", password = "1")
	public void validateUpdateOk() throws Exception {

		User userToSave = new User();
		userToSave.setUsername("a");
		userToSave.setPassword("b");
		userToSave.setFullname("c");
		userToSave.setRole("d");

		when(userService.saveUser(userToSave)).thenReturn(userToSave);

		mockMvc.perform(post("/validateUserUpdate").content(asJsonString(userToSave)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(redirectedUrl("/userList"));
	}

	@Test
	@WithMockUser(username = "user", password = "1")
	public void testDeleteUser() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/deleteUser/{id}", 2))
		.andExpect(redirectedUrl("/userList"));

	}
}
