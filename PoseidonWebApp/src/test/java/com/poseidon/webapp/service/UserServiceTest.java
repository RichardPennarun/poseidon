package com.poseidon.webapp.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poseidon.webapp.model.User;
import com.poseidon.webapp.model.User;

@SpringBootTest
public class UserServiceTest {
	

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
		userService = new UserService();
    }


	@Test
	public void userServiceTest() {
		User userToSave = new User();
		userToSave.setUsername("Adam");
		userToSave.setFullname("Adamito");
		userToSave.setRole("role");
		userToSave.setPassword("123");

		User createdUser = userService.saveUser(userToSave);
		//assertThat(createdUser).isEqualTo(userToSave);

		userService.getUsers();
		
		userService.getUser(createdUser.getId());
		
		userService.saveUser(createdUser);
		
		userService.deleteUser(createdUser.getId());
		
	}
	
	
	
	
}
