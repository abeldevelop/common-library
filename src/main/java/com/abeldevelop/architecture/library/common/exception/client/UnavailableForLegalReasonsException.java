package com.abeldevelop.architecture.library.common.exception.client;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.abeldevelop.architecture.library.common.exception.AbelDevelopException;

/**
 * The Class UnavailableForLegalReasonsException.
 * 
 * @since 1.0.0
 */
public class UnavailableForLegalReasonsException extends AbelDevelopException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5624876208910624713L;
	
	/** The Constant STATUS. */
	private static final HttpStatus STATUS = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS;

	/**
	 * Instantiates a new unavailable for legal reasons exception.
	 *
	 * @param message the message
	 */
	public UnavailableForLegalReasonsException(String message) {
		super(message, STATUS);
	}

	/**
	 * Instantiates a new unavailable for legal reasons exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public UnavailableForLegalReasonsException(String message, List<Object> arguments) {
		super(message, STATUS, arguments);
	}

	/**
	 * Instantiates a new unavailable for legal reasons exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public UnavailableForLegalReasonsException(String message, Throwable cause) {
		super(message, STATUS, cause);
	}

	/**
	 * Instantiates a new unavailable for legal reasons exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public UnavailableForLegalReasonsException(String message, List<Object> arguments, Throwable cause) {
		super(message, STATUS, arguments, cause);
	}
	
}
