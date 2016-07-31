package com.moviebuff.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class DuplicateUserException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4177975937456365227L;
	
	public DuplicateUserException(String message){
		super(message);
	}
	
	public DuplicateUserException(String message, Throwable cause){
		super(message, cause);
	}
}
