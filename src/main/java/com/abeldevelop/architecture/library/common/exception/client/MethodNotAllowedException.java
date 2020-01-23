package com.abeldevelop.architecture.library.common.exception.client;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.abeldevelop.architecture.library.common.exception.AbelDevelopException;

/**
 * The Class MethodNotAllowedException.
 * 
 * @since 1.0.0
 */
public class MethodNotAllowedException extends AbelDevelopException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5624876208910624713L;
	
	/** The Constant STATUS. */
	private static final HttpStatus STATUS = HttpStatus.METHOD_NOT_ALLOWED;

	/**
	 * Instantiates a new method not allowed exception.
	 *
	 * @param message the message
	 */
	public MethodNotAllowedException(String message) {
		super(message, STATUS);
	}

	/**
	 * Instantiates a new method not allowed exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public MethodNotAllowedException(String message, List<Object> arguments) {
		super(message, STATUS, arguments);
	}

	/**
	 * Instantiates a new method not allowed exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public MethodNotAllowedException(String message, Throwable cause) {
		super(message, STATUS, cause);
	}

	/**
	 * Instantiates a new method not allowed exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public MethodNotAllowedException(String message, List<Object> arguments, Throwable cause) {
		super(message, STATUS, arguments, cause);
	}
	
}
