package com.poseidon.API.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.API.model.User;
import com.poseidon.API.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> getUser(final Integer id) {
		return userRepository.findById(id);
	}
	
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	public void deleteUser(final Integer id) {
		userRepository.deleteById(id);
	}
	
	public User saveUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}

}
