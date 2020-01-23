package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class MethodNotAllowedExceptionTest {

	@Test
	public void test_MethodNotAllowedException() {
		new MethodNotAllowedException("", new ArrayList<Object>());
		new MethodNotAllowedException("", new RuntimeException());
		new MethodNotAllowedException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new MethodNotAllowedException("").getStatus().value();
		int expected = HttpStatus.METHOD_NOT_ALLOWED.value();
		
		assertEquals(expected, actual);
	}
	
}
