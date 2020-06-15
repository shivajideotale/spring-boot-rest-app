package com.spring.rest.dto;

import java.util.ArrayList;
import java.util.List;

public class FieldErrorDTO extends ApiErrorDTO {

	private List<Error> errors = new ArrayList<FieldErrorDTO.Error>();


	public List<Error> getErrors() {
		return errors;
	}

	public void addErrors(String field, String message) {
		Error error = new Error();
		error.setField(field);
		error.setMessage(message);
		errors.add(error);
	}

	class Error {
		private String field;
		private String message;

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}

}
