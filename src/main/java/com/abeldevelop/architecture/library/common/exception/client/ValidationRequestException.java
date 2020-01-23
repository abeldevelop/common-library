package com.abeldevelop.architecture.library.common.exception.client;

import java.util.List;

/**
 * The Class ValidationRequestException.
 * 
 * @since 1.0.0
 */
public class ValidationRequestException extends BadRequestException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -321979208013613486L;

	/**
	 * Instantiates a new validation request exception.
	 *
	 * @param message the message
	 */
	public ValidationRequestException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new validation request exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public ValidationRequestException(String message, List<Object> arguments) {
		super(message, arguments);
	}
	
	/**
	 * Instantiates a new validation request exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ValidationRequestException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Instantiates a new validation request exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public ValidationRequestException(String message, List<Object> arguments, Throwable cause) {
		super(message, arguments, cause);
	}
	
}