package com.abeldevelop.architecture.library.common.config.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abeldevelop.architecture.library.common.config.property.ErrorCodeArchitectureProperties;
import com.abeldevelop.architecture.library.common.dto.exception.ErrorResponseResource;
import com.abeldevelop.architecture.library.common.dto.exception.ErrorResponseResource.ErrorResponseResourceBuilder;
import com.abeldevelop.architecture.library.common.enums.Environments;
import com.abeldevelop.architecture.library.common.exception.AbelDevelopException;
import com.abeldevelop.architecture.library.common.exception.client.BadRequestException;
import com.abeldevelop.architecture.library.common.mapper.exception.StackTraceMapper;
import com.abeldevelop.architecture.library.common.service.ErrorMessageService;

import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
@RestController
public class AbelDevelopExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String ERROR_LOG_PREFIX = "ErrorResponseResource: {}";

	private final Environment environment;
	private final ErrorMessageService errorMessageService;
	private final Tracer tracer;
	private final StackTraceMapper stackTraceMapper;
	private final ErrorCodeArchitectureProperties errorCodeArchitectureProperties;
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		if (ex instanceof AbelDevelopException) {
			status = ((AbelDevelopException) ex).getStatus();
		}
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(new BadRequestException(errorCodeArchitectureProperties.getRequestFieldValueNotValid(), Arrays.asList(ex.getValue()), ex), status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleResponseException(ex, status);
	}

	@Override
	protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
		return handleResponseException(ex, status);
	}

	private ResponseEntity<Object> handleResponseException(Exception ex, HttpStatus status) {
		ErrorResponseResource errorResponseResource = createErrorResponseResource(ex, status);
		
		HttpHeaders headers = new HttpHeaders();
		
		if (status.is5xxServerError()) {
			log.error(ERROR_LOG_PREFIX, errorResponseResource);
		} else {
			log.warn(ERROR_LOG_PREFIX, errorResponseResource);
		}

		return new ResponseEntity<>(errorResponseResource, headers, status);
	}

	private ErrorResponseResource createErrorResponseResource(Exception ex, HttpStatus status) {
		ErrorResponseResourceBuilder errorResponseResourceBuilder = ErrorResponseResource.builder();
		errorResponseResourceBuilder.timestamp(LocalDateTime.now());
		errorResponseResourceBuilder.status(status.value());
		errorResponseResourceBuilder.error(status.getReasonPhrase());
		if(tracer.currentSpan() != null && tracer.currentSpan().context() != null) {
			errorResponseResourceBuilder.code(tracer.currentSpan().context().traceIdString());
		}
		setMessageToResponseResourceBuilder(ex, errorResponseResourceBuilder, status);
		addSensitiveInformation(ex, errorResponseResourceBuilder);
		return errorResponseResourceBuilder.build();
	}

	private void addSensitiveInformation(Exception exception,
			ErrorResponseResourceBuilder errorResponseResourceBuilder) {
		if (!Arrays.asList(environment.getActiveProfiles()).contains(Environments.PRO.getEnvironment())) {
			if (exception.getCause() instanceof Exception) {
				errorResponseResourceBuilder.cause(createErrorResponseResource((Exception) exception.getCause(),
						HttpStatus.INTERNAL_SERVER_ERROR));
			}
			errorResponseResourceBuilder.detail(exception.getClass().getCanonicalName());
			errorResponseResourceBuilder.stackTrace(stackTraceMapper.map(exception.getStackTrace()));
		}
	}

	private String getMethodArgumentNotValidExceptionMessage(MethodArgumentNotValidException exception) {
		FieldError fieldError = (FieldError) exception.getBindingResult().getAllErrors().get(0);
		return getMessageFromProperties(fieldError.getDefaultMessage());
	}
	
	private String messageFormatter(String message, List<Object> arguments) {
		return MessageFormatter.arrayFormat(message, arguments.toArray()).getMessage();
	}
	
	private String getMessageFromProperties(String code) {
		return errorMessageService.getMessage(code).orElse(code);
	}
	
	private void setMessageToResponseResourceBuilder(Exception ex, ErrorResponseResourceBuilder errorResponseResourceBuilder, HttpStatus status) {
	    if(ex instanceof AbelDevelopException) {
            String message = getMessageFromProperties(ex.getMessage());
            List<Object> arguments = ((AbelDevelopException) ex).getArguments();
            if(arguments != null && !arguments.isEmpty()) {
                message = messageFormatter(message, arguments);
            }
            errorResponseResourceBuilder.message(message);
        } else if(ex instanceof MethodArgumentNotValidException) {
            errorResponseResourceBuilder.message(getMethodArgumentNotValidExceptionMessage((MethodArgumentNotValidException) ex));
        } else {
        	errorResponseResourceBuilder.message(status.getReasonPhrase());
        }
	}
}
