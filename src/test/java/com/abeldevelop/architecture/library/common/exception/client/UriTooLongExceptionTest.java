package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class UriTooLongExceptionTest {

	@Test
	public void test_UriTooLongException() {
		new UriTooLongException("", new ArrayList<Object>());
		new UriTooLongException("", new RuntimeException());
		new UriTooLongException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new UriTooLongException("").getStatus().value();
		int expected = HttpStatus.URI_TOO_LONG.value();
		
		assertEquals(expected, actual);
	}
	
}
