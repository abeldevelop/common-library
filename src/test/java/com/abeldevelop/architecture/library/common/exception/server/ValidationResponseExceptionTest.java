package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class ValidationResponseExceptionTest {

	@Test
	public void test_ValidationResponseException() {
		new ValidationResponseException("", new ArrayList<Object>());
		new ValidationResponseException("", new RuntimeException());
		new ValidationResponseException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new ValidationResponseException("").getStatus().value();
		int expected = HttpStatus.INTERNAL_SERVER_ERROR.value();
		
		assertEquals(expected, actual);
	}
}
