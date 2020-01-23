package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class ConflictExceptionTest {

	@Test
	public void test_ConflictException() {
		new ConflictException("", new ArrayList<Object>());
		new ConflictException("", new RuntimeException());
		new ConflictException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new ConflictException("").getStatus().value();
		int expected = HttpStatus.CONFLICT.value();
		
		assertEquals(expected, actual);
	}
	
}
