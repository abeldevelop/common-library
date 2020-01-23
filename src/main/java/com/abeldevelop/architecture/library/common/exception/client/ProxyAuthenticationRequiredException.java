package com.abeldevelop.architecture.library.common.exception.client;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.abeldevelop.architecture.library.common.exception.AbelDevelopException;

/**
 * The Class ProxyAuthenticationRequiredException.
 * 
 * @since 1.0.0
 */
public class ProxyAuthenticationRequiredException extends AbelDevelopException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5624876208910624713L;
	
	/** The Constant STATUS. */
	private static final HttpStatus STATUS = HttpStatus.PROXY_AUTHENTICATION_REQUIRED;

	/**
	 * Instantiates a new proxy authentication required exception.
	 *
	 * @param message the message
	 */
	public ProxyAuthenticationRequiredException(String message) {
		super(message, STATUS);
	}

	/**
	 * Instantiates a new proxy authentication required exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 */
	public ProxyAuthenticationRequiredException(String message, List<Object> arguments) {
		super(message, STATUS, arguments);
	}

	/**
	 * Instantiates a new proxy authentication required exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public ProxyAuthenticationRequiredException(String message, Throwable cause) {
		super(message, STATUS, cause);
	}

	/**
	 * Instantiates a new proxy authentication required exception.
	 *
	 * @param message the message
	 * @param arguments the arguments
	 * @param cause the cause
	 */
	public ProxyAuthenticationRequiredException(String message, List<Object> arguments, Throwable cause) {
		super(message, STATUS, arguments, cause);
	}
	
}
