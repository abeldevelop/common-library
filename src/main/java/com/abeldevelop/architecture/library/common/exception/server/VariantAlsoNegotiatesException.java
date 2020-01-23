package com.abeldevelop.architecture.library.common.exception.server;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.abeldevelop.architecture.library.common.exception.AbelDevelopException;

/**
 * The Class VariantAlsoNegotiatesException.
 * 
 * @since 1.0.0
 */
public class VariantAlsoNegotiatesException extends AbelDevelopException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5624876208910624713L;
	
	/** The Constant STATUS. */
	private static final HttpStatus STATUS = HttpStatus.VARIANT_ALSO_NEGOTIATES;

	/**
	 * Instantiates a new variant also negotiates exception.
	 *
	 * @param message the message
	 */
	public VariantAlsoNegotiatesException(String message) {
		super(message, STATUS);
	}

	/**
	 * Instantiates a new variant also negotiates exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public VariantAlsoNegotiatesException(String message, List<Object> arguments) {
		super(message, STATUS, arguments);
	}

	/**
	 * Instantiates a new variant also negotiates exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public VariantAlsoNegotiatesException(String message, Throwable cause) {
		super(message, STATUS, cause);
	}

	/**
	 * Instantiates a new variant also negotiates exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public VariantAlsoNegotiatesException(String message, List<Object> arguments, Throwable cause) {
		super(message, STATUS, arguments, cause);
	}
	
}
