package com.abeldevelop.architecture.library.common.config.exception;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyEditor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.abeldevelop.architecture.library.common.config.i18n.Translator;
import com.abeldevelop.architecture.library.common.dto.exception.ErrorResponseResource;
import com.abeldevelop.architecture.library.common.exception.client.BadRequestException;
import com.abeldevelop.architecture.library.common.mapper.exception.StackTraceMapper;

import brave.Span;
import brave.Tracer;

@ExtendWith(MockitoExtension.class)
public class AbelDevelopExceptionHandlerTest {

	private AbelDevelopExceptionHandler abelDevelopExceptionHandler;
	
	@Mock
	private Environment environment;
	
	@Mock
	private Translator translator;
	
	@Mock
	private Tracer tracer;
	
	@Mock
    private Span span;
	
	@Mock
	private StackTraceMapper stackTraceMapper;
	
	@BeforeEach
	public void setUp() {
		abelDevelopExceptionHandler = new AbelDevelopExceptionHandler(environment, translator, tracer, stackTraceMapper);
		Mockito.when(tracer.currentSpan()).thenReturn(null);
	}

	@Test
	public void test_handleMethodArgumentNotValid() {
		
		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleMethodArgumentNotValid(new MethodArgumentNotValidException(null, getBindingResult()), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message(null)
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleHttpRequestMethodNotSupported() {
		
		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleHttpRequestMethodNotSupported(new HttpRequestMethodNotSupportedException("method"), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Bad Request")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleHttpMediaTypeNotSupported() {

		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleHttpMediaTypeNotSupported(new HttpMediaTypeNotSupportedException("message"), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Bad Request")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleHttpMediaTypeNotAcceptable() {

		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleHttpMediaTypeNotAcceptable(new HttpMediaTypeNotAcceptableException("message"), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Bad Request")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleMissingPathVariable() {

		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleMissingPathVariable(new MissingPathVariableException(null, null), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Bad Request")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleMissingServletRequestParameter() {

		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleMissingServletRequestParameter(new MissingServletRequestParameterException(null, null), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Bad Request")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleServletRequestBindingException() {

		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleServletRequestBindingException(new ServletRequestBindingException("msg"), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Bad Request")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Disabled
	@Test
	public void test_handleConversionNotSupported() {

		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleConversionNotSupported(new ConversionNotSupportedException(new PropertyChangeEvent(null, null, null, null), null, null), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(503)
					.error("Service Unavailable")
					.message("Service Unavailable")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.SERVICE_UNAVAILABLE);
		
		checkResult(actual, expected);
	}
	
	@Disabled
	@Test
	public void test_handleTypeMismatch() {

		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleTypeMismatch(new TypeMismatchException(new PropertyChangeEvent(null, "propertyName", null, null), null), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(503)
					.error("Service Unavailable")
					.message("Service Unavailable")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.SERVICE_UNAVAILABLE);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleHttpMessageNotReadable() {

		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleHttpMessageNotReadable(new HttpMessageNotReadableException("msg"), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Bad Request")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleHttpMessageNotWritable() {

		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleHttpMessageNotWritable(new HttpMessageNotWritableException("msg"), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Bad Request")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleMissingServletRequestPart() {

		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleMissingServletRequestPart(new MissingServletRequestPartException(null), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Bad Request")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Disabled
	@Test
	public void test_handleBindException() {

		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleBindException(new BindException(getBindingResult()), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(503)
					.error("Service Unavailable")
					.message("Service Unavailable")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.SERVICE_UNAVAILABLE);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleNoHandlerFoundException() {

		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleNoHandlerFoundException(new NoHandlerFoundException(null, null, null), new HttpHeaders(), HttpStatus.BAD_REQUEST, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Bad Request")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);
	}
	
	@Test
	public void test_handleAsyncRequestTimeoutException() {
		
		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleAsyncRequestTimeoutException(new AsyncRequestTimeoutException(), new HttpHeaders(), HttpStatus.SERVICE_UNAVAILABLE, null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(503)
					.error("Service Unavailable")
					.message("Service Unavailable")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.SERVICE_UNAVAILABLE);
		
		checkResult(actual, expected);

	}
	
	@Test
	public void test_handleBadRequestException() {
		
		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		Mockito.when(translator.translate(Mockito.anyString())).thenReturn("Message");
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleAllExceptions(new BadRequestException("message"), null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Message")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);

	}
	
	@Test
	public void test_handleBadRequestExceptionWithParameters() {
		
		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		Mockito.when(translator.translate(Mockito.anyString())).thenReturn("Message {}");
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleAllExceptions(new BadRequestException("message", Arrays.asList("one")), null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(400)
					.error("Bad Request")
					.message("Message one")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
		
		checkResult(actual, expected);

	}
	
	@Test
	public void test_handleRuntimeException() {
		
		Mockito.when(environment.getActiveProfiles()).thenReturn(new String[] {"dev"});
		Mockito.when(stackTraceMapper.map(Mockito.any())).thenReturn(Arrays.asList(""));
		
		ResponseEntity<Object> actual = abelDevelopExceptionHandler.handleAllExceptions(new RuntimeException("message", new RuntimeException("message")), null);
		ResponseEntity<Object> expected = new ResponseEntity<>(
				ErrorResponseResource.builder()
					.status(500)
					.error("Internal Server Error")
					.message("Internal Server Error")
					.build(), 
				new HttpHeaders(), 
				HttpStatus.INTERNAL_SERVER_ERROR);
		
		checkResult(actual, expected);

	}
	
	private void checkResult(ResponseEntity<Object> actual, ResponseEntity<Object> expected) {

		
		ErrorResponseResource expectedBody = (ErrorResponseResource) expected.getBody();
		ErrorResponseResource actualBody = (ErrorResponseResource) actual.getBody();
		
		assertEquals(expected.getStatusCodeValue(), actual.getStatusCodeValue());
		assertNotNull(actualBody.getTimestamp());
		assertEquals(expectedBody.getStatus(), actualBody.getStatus());
		assertEquals(expectedBody.getError(), actualBody.getError());
		assertEquals(expectedBody.getCode(), actualBody.getCode());
		assertEquals(expectedBody.getMessage(), actualBody.getMessage());
		assertNotNull(actualBody.getDetail());
	}
	
	private BindingResult getBindingResult() {
		return new BindingResult() {
			
			@Override
			public void setNestedPath(String nestedPath) {}
			
			@Override
			public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {}
			
			@Override
			public void rejectValue(String field, String errorCode, String defaultMessage) {}
			
			@Override
			public void rejectValue(String field, String errorCode) {}
			
			@Override
			public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {}
			
			@Override
			public void reject(String errorCode, String defaultMessage) {}
			
			@Override
			public void reject(String errorCode) {}
			
			@Override
			public void pushNestedPath(String subPath) {}
			
			@Override
			public void popNestedPath() throws IllegalStateException {}
			
			@Override
			public boolean hasGlobalErrors() {return false;}
			
			@Override
			public boolean hasFieldErrors(String field) {return false;}
			
			@Override
			public boolean hasFieldErrors() {return false;}
			
			@Override
			public boolean hasErrors() {return false;}
			
			@Override
			public String getObjectName() {return null;}
			
			@Override
			public String getNestedPath() {return null;}
			
			@Override
			public List<ObjectError> getGlobalErrors() {return null;}
			
			@Override
			public int getGlobalErrorCount() {return 0;}
			
			@Override
			public ObjectError getGlobalError() {return null;}
			
			@Override
			public Object getFieldValue(String field) {return null;}
			
			@Override
			public Class<?> getFieldType(String field) {return null;}
			
			@Override
			public List<FieldError> getFieldErrors(String field) {return null;}
			
			@Override
			public List<FieldError> getFieldErrors() {return null;}
			
			@Override
			public int getFieldErrorCount(String field) {return 0;}
			
			@Override
			public int getFieldErrorCount() {return 0;}
			
			@Override
			public FieldError getFieldError(String field) {return null;}
			
			@Override
			public FieldError getFieldError() {return null;}
			
			@Override
			public int getErrorCount() {return 0;}
			
			@Override
			public List<ObjectError> getAllErrors() {
				return Arrays.asList(new FieldError("objectName", "field", "defaultMessage"));
			}
			
			@Override
			public void addAllErrors(Errors errors) {}
			
			@Override
			public String[] resolveMessageCodes(String errorCode, String field) {
				return null;
			}
			
			@Override
			public String[] resolveMessageCodes(String errorCode) {
				return null;
			}
			
			@Override
			public Object getTarget() {
				return null;
			}
			
			@Override
			public Object getRawFieldValue(String field) {
				return null;
			}
			
			@Override
			public PropertyEditorRegistry getPropertyEditorRegistry() {
				return null;
			}
			
			@Override
			public Map<String, Object> getModel() {
				return null;
			}
			
			@Override
			public PropertyEditor findEditor(String field, Class<?> valueType) {
				return null;
			}
			
			@Override
			public void addError(ObjectError error) {
			}
		};
	}
}
