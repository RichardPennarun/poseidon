package com.poseidon.API.service;

import java.util.ArrayList;
import java.util.Optional;

import com.poseidon.API.model.User;

public interface UserService {

	Iterable<User> getUsers();
	
	Optional<User> getUser(final Integer id);
	
	void deleteUser(final Integer id);
	
	User saveUser(User user);
	
	// Pour authentification
	User getUser(String username) ;

}
