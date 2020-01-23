package com.abeldevelop.architecture.library.common.exception.client;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.abeldevelop.architecture.library.common.exception.AbelDevelopException;

/**
 * The Class RequestedRangeNotSatisfiableException.
 * 
 * @since 1.0.0
 */
public class RequestedRangeNotSatisfiableException extends AbelDevelopException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5624876208910624713L;
	
	/** The Constant STATUS. */
	private static final HttpStatus STATUS = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE;

	/**
	 * Instantiates a new requested range not satisfiable exception.
	 *
	 * @param message the message
	 */
	public RequestedRangeNotSatisfiableException(String message) {
		super(message, STATUS);
	}

	/**
	 * Instantiates a new requested range not satisfiable exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public RequestedRangeNotSatisfiableException(String message, List<Object> arguments) {
		super(message, STATUS, arguments);
	}

	/**
	 * Instantiates a new requested range not satisfiable exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public RequestedRangeNotSatisfiableException(String message, Throwable cause) {
		super(message, STATUS, cause);
	}

	/**
	 * Instantiates a new requested range not satisfiable exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public RequestedRangeNotSatisfiableException(String message, List<Object> arguments, Throwable cause) {
		super(message, STATUS, arguments, cause);
	}
	
}
