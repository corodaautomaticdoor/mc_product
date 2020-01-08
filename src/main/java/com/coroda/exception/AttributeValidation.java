package com.coroda.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class AttributeValidation {

	@JsonProperty("message")
	private String message;
	@JsonProperty("uri")
	private String uriRequested;

	public AttributeValidation(RuntimeException exception, String uriRequested) {
		this.message = exception.getMessage();
		this.uriRequested = uriRequested;
	}

	public AttributeValidation(int statusCode, String message, String uriRequested) {
		this.message = message;
		this.uriRequested = uriRequested;
	}
}
