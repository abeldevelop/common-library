package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class RequestTimeoutExceptionTest {

	@Test
	public void test_RequestTimeoutException() {
		new RequestTimeoutException("", new ArrayList<Object>());
		new RequestTimeoutException("", new RuntimeException());
		new RequestTimeoutException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new RequestTimeoutException("").getStatus().value();
		int expected = HttpStatus.REQUEST_TIMEOUT.value();
		
		assertEquals(expected, actual);
	}
	
}
