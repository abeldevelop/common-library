package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class ServiceUnavailableExceptionTest {

	@Test
	public void test_ServiceUnavailableException() {
		new ServiceUnavailableException("", new ArrayList<Object>());
		new ServiceUnavailableException("", new RuntimeException());
		new ServiceUnavailableException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new ServiceUnavailableException("").getStatus().value();
		int expected = HttpStatus.SERVICE_UNAVAILABLE.value();
		
		assertEquals(expected, actual);
	}
	
}
