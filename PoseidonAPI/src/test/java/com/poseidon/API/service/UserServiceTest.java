package com.poseidon.API.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poseidon.API.model.User;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserServiceImpl userService;

	@Before
	private void setUp() {
		userService = new UserServiceImpl();
	}

	@Test
	public void userServiceTest() {
		User userToSave = new User();
		userToSave.setUsername("Adam");
		userToSave.setFullname("Adamito");
		userToSave.setRole("role");
		userToSave.setPassword("123");

		User createdUser = userService.saveUser(userToSave);
		assertThat(createdUser).isEqualTo(userToSave);

		userService.getUsers();
		
		userService.getUser(createdUser.getId());
		
		userService.getUser(createdUser.getUsername());
		
		userService.deleteUser(createdUser.getId());
		
	}
}
