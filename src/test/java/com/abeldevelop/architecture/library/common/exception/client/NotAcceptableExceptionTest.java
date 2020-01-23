package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class NotAcceptableExceptionTest {

	@Test
	public void test_NotAcceptableException() {
		new NotAcceptableException("", new ArrayList<Object>());
		new NotAcceptableException("", new RuntimeException());
		new NotAcceptableException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new NotAcceptableException("").getStatus().value();
		int expected = HttpStatus.NOT_ACCEPTABLE.value();
		
		assertEquals(expected, actual);
	}
	
}
