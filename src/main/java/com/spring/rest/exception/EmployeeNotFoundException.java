package com.spring.rest.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(int id) {
		super("Employee id not found : " + id);
	}

}
