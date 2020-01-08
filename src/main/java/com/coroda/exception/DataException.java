package com.coroda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataException(String message) {
		super(message);
	}
}
