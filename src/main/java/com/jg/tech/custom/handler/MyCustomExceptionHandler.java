package com.jg.tech.custom.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jg.tech.exception.ContactNotFoundException;

/*
 * Common Catch block code
 * */

@RestControllerAdvice
public class MyCustomExceptionHandler {
	
	@ExceptionHandler(ContactNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(ContactNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
