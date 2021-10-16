package com.poseidon.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.webapp.model.User;
import com.poseidon.webapp.proxy.UserProxy;

@Service
public class UserService {

    @Autowired
    private UserProxy userProxy;

	
    public Iterable<User> getUsers() {
        return userProxy.getUsers();
    }
	
	public User getUser(final int id) {
		return userProxy.getUser(id);
	}
	
	public void deleteUser(final int id) {
		userProxy.deleteUser(id);
	}
	
	public User saveUser(User user) {
		User savedUser;

		if(user.getId() == 0) {
			savedUser = userProxy.createUser(user);
		} else {
			savedUser = userProxy.updateUser(user);
		}
		
		return savedUser;
	}

}
