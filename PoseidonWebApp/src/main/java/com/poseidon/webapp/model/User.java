package com.poseidon.webapp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import com.poseidon.webapp.config.ValidPassword;

@Component
public class User {
	
	private int id;
	@NotBlank(message="Username is mandatory")
	private String username;
	@ValidPassword
	private String password;
	@NotBlank(message="Full name is mandatory")
	private String fullname;
	@NotEmpty(message="Role is mandatory")
	private String role;
	
	public User() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
