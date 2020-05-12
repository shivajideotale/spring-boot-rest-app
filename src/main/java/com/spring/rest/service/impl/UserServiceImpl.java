package com.spring.rest.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.rest.model.User;
import com.spring.rest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	List<User> userList = new ArrayList<>(Arrays.asList(new User(1, "Sagar"), new User(2, "Preeti")));

	@Override
	public List<User> getAllUsers() {

		return userList;
	}

	@Override
	public User getUserById(int userId) {

		return userList.stream().filter(u -> u.getUserId() == userId).findFirst().get();

		// User us = userList.get(userId);
		// return us;
		/*
		 * User user = null;
		 * 
		 * for(int i = 0; i < userList.size(); i++) { user = userList.get(i);
		 * if(user.getUserId() == userId) { return user; }//else return user; } return
		 * user;
		 */
	}

	@Override
	public void addUser(User user) {

		userList.add(user);
	}

	@Override
	public void updateUser(User user, int userId) {

		for (int i = 0; i < userList.size(); i++) {
			User u = userList.get(i);
			if (u.getUserId() == userId) {
				userList.set(i, user);
				return;
			}
		}
	}

	@Override
	public void deleteUser(int userId) {

		userList.remove(userId);
	}
}
