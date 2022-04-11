package com.jg.tech.exception;

public class ContactNotFoundException extends RuntimeException {

	/**
	 * unchecked Exception i.e
	 *  not checked during compilation execution time 
	 *  checked when data recieved 
	 */
	private static final long serialVersionUID = 1L;
	
	public ContactNotFoundException() {
		super();
	}
	
	public ContactNotFoundException(String message) {
		super(message);
	
	}
	
	
	

}

