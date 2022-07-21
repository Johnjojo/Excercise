package com.exercise.artist.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exercise.artist.exception.CustomAPIException;

@ControllerAdvice
public class customExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { CustomAPIException.class })
	  public ResponseEntity<Object> handleApiRequestException(CustomAPIException e) {
	    return ResponseEntity.status( e.getStatus())
	                         .body(e.getMessage());
	  }
}
