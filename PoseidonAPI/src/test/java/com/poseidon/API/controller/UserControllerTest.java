package com.poseidon.API.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poseidon.API.model.User;
import com.poseidon.API.service.UserService;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	// @Before
	public void setUp() throws Exception {

	}

	@Test
	public void testGetUsers() throws Exception {
		mockMvc.perform(get("/users")).andExpect(status().isOk());
	}

	@Test
	public void testFindByUsername() throws Exception {
		mockMvc.perform(get("/user/username")).andExpect(status().isOk());
	}

	@Test
	public void testGetUser() throws Exception {
		mockMvc.perform(get("/user/id/{id}", 2)).andExpect(status().isOk());
	}

	@Test
	public void testDeleteUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/user/{id}", 2)).andExpect(status().isOk());
	}

	@Test
	public void testCreate() throws Exception {
		mockMvc.perform(post("/user").content(asJsonString(new User())).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper objectMapper = new ObjectMapper();
			final String jsonContent = objectMapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	@Test
	public void testUpdateUser() throws Exception {
		Optional<User> user = Optional.of(new User());
		User userToSave = new User();
		userToSave.setUsername("a");
		userToSave.setPassword("b");
		userToSave.setFullname("c");
		userToSave.setRole("d");
		
		when(userService.getUser(2)).thenReturn(user);
		when(userService.saveUser(userToSave)).thenReturn(userToSave);
		
		mockMvc.perform(put("/user/{id}", 2)
				.content(asJsonString(userToSave))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.username", is("a")))
				.andExpect(jsonPath("$.password", is("b")))
				.andExpect(jsonPath("$.fullname", is("c")))
				.andExpect(jsonPath("$.role", is("d")));
	}

}
