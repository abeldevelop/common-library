package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class TooEarlyExceptionTest {

	@Test
	public void test_TooEarlyException() {
		new TooEarlyException("", new ArrayList<Object>());
		new TooEarlyException("", new RuntimeException());
		new TooEarlyException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new TooEarlyException("").getStatus().value();
		int expected = HttpStatus.TOO_EARLY.value();
		
		assertEquals(expected, actual);
	}
	
}
