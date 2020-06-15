package com.spring.rest.exception;

public class EmployeeNotFoundException extends RuntimeException {

	public EmployeeNotFoundException(int id) {
		super("Employee id not found : " + id);
	}

}
