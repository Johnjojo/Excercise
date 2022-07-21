package com.exercise.artist.exception;

import org.springframework.http.HttpStatus;

public abstract class CustomAPIException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; 
	
	public CustomAPIException(String message){
		super(message);
	}

	public abstract HttpStatus getStatus();

}
