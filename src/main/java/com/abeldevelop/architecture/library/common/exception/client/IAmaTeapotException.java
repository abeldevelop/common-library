package com.abeldevelop.architecture.library.common.exception.client;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.abeldevelop.architecture.library.common.exception.AbelDevelopException;

/**
 * The Class IAmaTeapotException.
 * 
 * @since 1.0.0
 */
public class IAmaTeapotException extends AbelDevelopException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5624876208910624713L;
	
	/** The Constant STATUS. */
	private static final HttpStatus STATUS = HttpStatus.I_AM_A_TEAPOT;

	/**
	 * Instantiates a new i ama teapot exception.
	 *
	 * @param message the message
	 */
	public IAmaTeapotException(String message) {
		super(message, STATUS);
	}

	/**
	 * Instantiates a new i ama teapot exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public IAmaTeapotException(String message, List<Object> arguments) {
		super(message, STATUS, arguments);
	}

	/**
	 * Instantiates a new i ama teapot exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public IAmaTeapotException(String message, Throwable cause) {
		super(message, STATUS, cause);
	}

	/**
	 * Instantiates a new i ama teapot exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public IAmaTeapotException(String message, List<Object> arguments, Throwable cause) {
		super(message, STATUS, arguments, cause);
	}
	
}
