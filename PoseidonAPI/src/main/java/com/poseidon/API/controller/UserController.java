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

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") final Integer id) {
		Optional<User> user = userService.getUser(id);
		if(user.isPresent()) {
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
		if(e.isPresent()) {
			User currentUser = e.get();
			
			
			/*
			 * String firstName = user.getFirstName(); if(firstName != null) {
			 * currentUser.setFirstName(firstName); } String lastName =
			 * user.getLastName(); if(lastName != null) {
			 * currentUser.setLastName(lastName);; } String mail = user.getMail();
			 * if(mail != null) { currentUser.setMail(mail); } String password =
			 * user.getPassword(); if(password != null) {
			 * currentUser.setPassword(password);; }
			 */
			userService.saveUser(currentUser);
			return currentUser;
		} else {
			return null;
		}
	}
	
	

}