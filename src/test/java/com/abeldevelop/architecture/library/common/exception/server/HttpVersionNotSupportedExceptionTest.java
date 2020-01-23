package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class HttpVersionNotSupportedExceptionTest {

	@Test
	public void test_HttpVersionNotSupportedException() {
		new HttpVersionNotSupportedException("", new ArrayList<Object>());
		new HttpVersionNotSupportedException("", new RuntimeException());
		new HttpVersionNotSupportedException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new HttpVersionNotSupportedException("").getStatus().value();
		int expected = HttpStatus.HTTP_VERSION_NOT_SUPPORTED.value();
		
		assertEquals(expected, actual);
	}
	
}
