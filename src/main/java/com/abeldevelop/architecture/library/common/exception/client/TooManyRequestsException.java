package com.abeldevelop.architecture.library.common.exception.client;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.abeldevelop.architecture.library.common.exception.AbelDevelopException;

/**
 * The Class TooManyRequestsException.
 * 
 * @since 1.0.0
 */
public class TooManyRequestsException extends AbelDevelopException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5624876208910624713L;
	
	/** The Constant STATUS. */
	private static final HttpStatus STATUS = HttpStatus.TOO_MANY_REQUESTS;

	/**
	 * Instantiates a new too many requests exception.
	 *
	 * @param message the message
	 */
	public TooManyRequestsException(String message) {
		super(message, STATUS);
	}

	/**
	 * Instantiates a new too many requests exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public TooManyRequestsException(String message, List<Object> arguments) {
		super(message, STATUS, arguments);
	}

	/**
	 * Instantiates a new too many requests exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public TooManyRequestsException(String message, Throwable cause) {
		super(message, STATUS, cause);
	}

	/**
	 * Instantiates a new too many requests exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public TooManyRequestsException(String message, List<Object> arguments, Throwable cause) {
		super(message, STATUS, arguments, cause);
	}
	
}
