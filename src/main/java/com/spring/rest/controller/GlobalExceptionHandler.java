package com.spring.rest.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.spring.rest.dto.ApiErrorDTO;
import com.spring.rest.dto.FieldErrorDTO;
import com.spring.rest.exception.EmployeeNotFoundException;
import com.spring.rest.exception.FieldValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(FieldValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrorDTO handleFieldException(HttpServletRequest req, FieldValidationException ex) {

		FieldErrorDTO errorDTO = new FieldErrorDTO();

		errorDTO.setPath(req.getRequestURI());
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		fieldErrors.forEach(err -> errorDTO.addErrors(err.getField(), err.getDefaultMessage()));
		return errorDTO;

	}

	@ResponseBody
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorDTO handleDataNotFoundException(HttpServletRequest req, EmployeeNotFoundException ex) {

		ApiErrorDTO errorDTO = new ApiErrorDTO();
		errorDTO.setPath(req.getRequestURI());
		errorDTO.setErrorMessage(ex.getMessage());
		errorDTO.setStatusCode(101);
		return errorDTO;

	}

}
