package com.poseidon.API.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poseidon.API.model.User;
import com.poseidon.API.service.UserService;
import com.poseidon.API.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// Get user by username
	@GetMapping("/user/{username}")
	public User findByUsername(@PathVariable("username") final String username) {
		User user = userService.getUser(username);
		// logger.info("User found by username.");
		return user;
	}

	@GetMapping("/user/id/{id}")
	public User getUser(@PathVariable("id") final Integer id) {
		Optional<User> user = userService.getUser(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

	@GetMapping("/users")
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") final Integer id) {
		userService.deleteUser(id);
	}

	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") final Integer id, @RequestBody User user) {
		Optional<User> e = userService.getUser(id);
		if (e.isPresent()) {
			User currentUser = e.get();

			String username = user.getUsername();
			if (username != null) {
				currentUser.setUsername(username);
			}
			String fullname = user.getFullname();
			if (fullname != null) {
				currentUser.setFullname(fullname);
				;
			}
			String role = user.getRole();
			if (role != null) {
				currentUser.setRole(role);
			}
			String password = user.getPassword();
			if (password != null) {
				currentUser.setPassword(password);
				;
			}

			userService.saveUser(currentUser);
			return currentUser;
		} else {
			return null;
		}
	}

}