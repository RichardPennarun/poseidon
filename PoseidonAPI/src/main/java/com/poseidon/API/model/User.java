package com.poseidon.API.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_name")
	private String username;
	private String password;
	@Column(name = "full_name")
	private String fullname;
	private String role;
	
	public User() {
	}

	public User(int id, String username, String password, String fullname, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
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

	@Override
	public String toString() {
		return "User [Id=" + id + ", username=" + username + ", password=" + password + ", fullname=" + fullname
				+ ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fullname, password, role, id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(fullname, other.fullname) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && id == other.id
				&& Objects.equals(username, other.username);
	}
	
	

}
