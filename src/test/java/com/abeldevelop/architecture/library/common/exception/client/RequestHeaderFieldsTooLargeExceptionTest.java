package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class RequestHeaderFieldsTooLargeExceptionTest {

	@Test
	public void test_RequestHeaderFieldsTooLargeException() {
		new RequestHeaderFieldsTooLargeException("", new ArrayList<Object>());
		new RequestHeaderFieldsTooLargeException("", new RuntimeException());
		new RequestHeaderFieldsTooLargeException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new RequestHeaderFieldsTooLargeException("").getStatus().value();
		int expected = HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.value();
		
		assertEquals(expected, actual);
	}
	
}
