package com.spring.rest.service;

import java.util.List;

import com.spring.rest.model.User;

public interface UserService {

	List<User> getAllUsers();
	
	User getUserById(int userId);

	void addUser(User user);

	void updateUser(User user, int userId);

	void deleteUser(int userId);
}
