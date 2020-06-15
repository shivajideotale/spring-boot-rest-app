package com.spring.rest.exception;

import org.springframework.validation.BindingResult;

public class FieldValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private BindingResult bindingResult;

	
	public FieldValidationException(String message,BindingResult bindingResult) {
		super(message);
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

}
