package com.moviebuff.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class IllegalUpdateException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7025674300933647994L;
	
	public IllegalUpdateException(String message){
		super(message);
	}
	
	public IllegalUpdateException(String message, Throwable cause){
		super(message, cause);
	}
}
