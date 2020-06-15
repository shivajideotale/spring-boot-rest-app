package com.spring.rest.exception;

import org.springframework.validation.BindingResult;

public class FieldException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private BindingResult bindingResult;

	
	public FieldException(String message,BindingResult bindingResult) {
		super(message);
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

}
