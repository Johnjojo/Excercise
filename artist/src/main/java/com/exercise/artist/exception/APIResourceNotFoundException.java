package com.exercise.artist.exception;

import org.springframework.http.HttpStatus;

public class APIResourceNotFoundException extends CustomAPIException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static HttpStatus status = HttpStatus.NOT_FOUND; 
	
	public APIResourceNotFoundException(String message) {
		super(message);
	}
	
	@Override
	public HttpStatus getStatus() {
		return status;
	}
}
