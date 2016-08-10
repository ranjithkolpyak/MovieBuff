package com.moviebuff.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE)
public class IllegalRoleException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1178069138818670131L;
	
	public IllegalRoleException(String message){
		super(message);
	}
	
	public IllegalRoleException(String message, Throwable cause){
		super(message, cause);
	}
}
