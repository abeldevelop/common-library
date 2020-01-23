package com.abeldevelop.architecture.library.common.exception.server;

import java.util.List;

/**
 * The Class ValidationResponseException.
 * 
 * @since 1.0.0
 */
public class ValidationResponseException extends InternalServerErrorException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -321979208013613486L;

	/**
	 * Instantiates a new validation response exception.
	 *
	 * @param message the message
	 */
	public ValidationResponseException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new validation response exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public ValidationResponseException(String message, List<Object> arguments) {
		super(message, arguments);
	}

	/**
	 * Instantiates a new validation response exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ValidationResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new validation response exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public ValidationResponseException(String message, List<Object> arguments, Throwable cause) {
		super(message, arguments, cause);
	}

}