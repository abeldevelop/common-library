package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class ValidationRequestExceptionTest {

	@Test
	public void test_ValidationRequestException() {
		new ValidationRequestException("", new ArrayList<Object>());
		new ValidationRequestException("", new RuntimeException());
		new ValidationRequestException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new ValidationRequestException("").getStatus().value();
		int expected = HttpStatus.BAD_REQUEST.value();
		
		assertEquals(expected, actual);
	}
}
