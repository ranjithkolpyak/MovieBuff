package com.moviebuff.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NoSuchResourceException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3017510057678440597L;
	
	public NoSuchResourceException(String message){
		super(message);
	}
	
	public NoSuchResourceException(String message, Throwable cause){
		super(message, cause);
	}
}
