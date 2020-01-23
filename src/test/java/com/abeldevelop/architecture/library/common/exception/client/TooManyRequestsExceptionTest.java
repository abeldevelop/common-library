package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class TooManyRequestsExceptionTest {

	@Test
	public void test_TooManyRequestsException() {
		new TooManyRequestsException("", new ArrayList<Object>());
		new TooManyRequestsException("", new RuntimeException());
		new TooManyRequestsException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new TooManyRequestsException("").getStatus().value();
		int expected = HttpStatus.TOO_MANY_REQUESTS.value();
		
		assertEquals(expected, actual);
	}
	
}
