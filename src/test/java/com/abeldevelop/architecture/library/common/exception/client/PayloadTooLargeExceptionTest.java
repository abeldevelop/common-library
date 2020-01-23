package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class PayloadTooLargeExceptionTest {

	@Test
	public void test_PayloadTooLargeException() {
		new PayloadTooLargeException("", new ArrayList<Object>());
		new PayloadTooLargeException("", new RuntimeException());
		new PayloadTooLargeException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new PayloadTooLargeException("").getStatus().value();
		int expected = HttpStatus.PAYLOAD_TOO_LARGE.value();
		
		assertEquals(expected, actual);
	}
	
}
