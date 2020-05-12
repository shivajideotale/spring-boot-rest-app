package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.model.User;
import com.spring.rest.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") int userId) {
		return userService.getUserById(userId);
	}

	@PostMapping
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@PutMapping(value = "/{id}")
	public void addUser(@RequestBody User user, @PathVariable("id") int userId) {
		userService.updateUser(user, userId);
	}

	@DeleteMapping(value = "/{id}")
	public void addUser(@PathVariable("id") int userId) {
		userService.deleteUser(userId);
	}
}
