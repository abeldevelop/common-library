package com.abeldevelop.architecture.library.common.exception;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;

/**
 * Gets the arguments.
 *
 * @return the arguments
 * 
 * @since 1.0.0
 */
@Getter
public class AbelDevelopException extends RuntimeException implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6581330406261507159L;
	
	/** The status. */
	private final HttpStatus status;
	
	/** The arguments. */
	private final List<Object> arguments;
	
	/**
	 * Instantiates a new abel develop exception.
	 *
	 * @param message the message
	 * @param status the status
	 */
	protected AbelDevelopException(String message, HttpStatus status) {
		super(message);
		this.status = status;
		this.arguments = null;
	}

	/**
	 * Instantiates a new abel develop exception.
	 *
	 * @param message the message
	 * @param status the status
	 * @param arguments the arguments
	 */
	protected AbelDevelopException(String message, HttpStatus status, List<Object> arguments) {
		super(message);
		this.status = status;
		this.arguments = arguments;
	}
	
	/**
	 * Instantiates a new abel develop exception.
	 *
	 * @param message the message
	 * @param status the status
	 * @param cause the cause
	 */
	protected AbelDevelopException(String message, HttpStatus status, Throwable cause) {
		super(message, cause);
		this.status = status;
		this.arguments = null;
	}
	
	/**
	 * Instantiates a new abel develop exception.
	 *
	 * @param message the message
	 * @param status the status
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	protected AbelDevelopException(String message, HttpStatus status, List<Object> arguments, Throwable cause) {
		super(message, cause);
		this.status = status;
		this.arguments = arguments;
	}
	
}