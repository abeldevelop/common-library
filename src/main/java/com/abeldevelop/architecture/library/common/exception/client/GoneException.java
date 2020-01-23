package com.abeldevelop.architecture.library.common.exception.client;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.abeldevelop.architecture.library.common.exception.AbelDevelopException;

/**
 * The Class GoneException.
 * 
 * @since 1.0.0
 */
public class GoneException extends AbelDevelopException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5624876208910624713L;
	
	/** The Constant STATUS. */
	private static final HttpStatus STATUS = HttpStatus.GONE;

	/**
	 * Instantiates a new gone exception.
	 *
	 * @param message the message
	 */
	public GoneException(String message) {
		super(message, STATUS);
	}

	/**
	 * Instantiates a new gone exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public GoneException(String message, List<Object> arguments) {
		super(message, STATUS, arguments);
	}

	/**
	 * Instantiates a new gone exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public GoneException(String message, Throwable cause) {
		super(message, STATUS, cause);
	}

	/**
	 * Instantiates a new gone exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public GoneException(String message, List<Object> arguments, Throwable cause) {
		super(message, STATUS, arguments, cause);
	}
	
}
