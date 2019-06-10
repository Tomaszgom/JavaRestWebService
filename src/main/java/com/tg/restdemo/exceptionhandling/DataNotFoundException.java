package com.tg.restdemo.exceptionhandling;

/**
 * 
 * Exception Class handling 'Data Not Found' exception
 *
 */

public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6328286661536343936L;
	
	public DataNotFoundException(String message) {
		super(message);
	}
	
}