package com.spring.rest.model;

import java.util.List;

public class User {

	private int userId;
	private String userName;
	
	public User(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
}
