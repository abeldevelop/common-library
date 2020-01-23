package com.abeldevelop.architecture.library.common.exception.client;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.abeldevelop.architecture.library.common.exception.AbelDevelopException;

/**
 * The Class RequestHeaderFieldsTooLargeException.
 * 
 * @since 1.0.0
 */
public class RequestHeaderFieldsTooLargeException extends AbelDevelopException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5624876208910624713L;
	
	/** The Constant STATUS. */
	private static final HttpStatus STATUS = HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE;

	/**
	 * Instantiates a new request header fields too large exception.
	 *
	 * @param message the message
	 */
	public RequestHeaderFieldsTooLargeException(String message) {
		super(message, STATUS);
	}

	/**
	 * Instantiates a new request header fields too large exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public RequestHeaderFieldsTooLargeException(String message, List<Object> arguments) {
		super(message, STATUS, arguments);
	}

	/**
	 * Instantiates a new request header fields too large exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public RequestHeaderFieldsTooLargeException(String message, Throwable cause) {
		super(message, STATUS, cause);
	}

	/**
	 * Instantiates a new request header fields too large exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public RequestHeaderFieldsTooLargeException(String message, List<Object> arguments, Throwable cause) {
		super(message, STATUS, arguments, cause);
	}
	
}
