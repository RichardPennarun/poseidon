package com.poseidon.webapp.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poseidon.webapp.model.User;
import com.poseidon.webapp.service.UserService;

@Controller
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("/userList")
	public String userList(Model model) {
		Iterable<User> listUser = userService.getUsers();
		model.addAttribute("users", listUser);
		logger.info("Return all users list");
		return "user/list";
	}

	@GetMapping("/createUser")
	public String addUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		logger.info("Return new user form");
		return "user/add";
	}

	@PostMapping("/validateUserAdd")
	public String validateAdd(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user/add";
		}
		// Cryptage du password
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		
		User savedUser = userService.saveUser(user);
		logger.info("New user added: " + savedUser + "");
		return "redirect:/userList";
	}

	@GetMapping("/updateUser/{id}")
	public String updateUser(@PathVariable("id") Integer id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		logger.info("Return update form");
		return "user/update";
	}

	@PostMapping("/validateUserUpdate")
	public String validateUpdate(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user/update";
		}
		User updatedUser = userService.saveUser(user);
		logger.info("User updated: " + updatedUser + "");
		return "redirect:/userList";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		logger.info("User number " + id + " deleted");
		return "redirect:/userList";
	}



}
