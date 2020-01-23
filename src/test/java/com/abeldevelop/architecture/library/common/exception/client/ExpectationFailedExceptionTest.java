package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class ExpectationFailedExceptionTest {

	@Test
	public void test_ExpectationFailedException() {
		new ExpectationFailedException("", new ArrayList<Object>());
		new ExpectationFailedException("", new RuntimeException());
		new ExpectationFailedException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new ExpectationFailedException("").getStatus().value();
		int expected = HttpStatus.EXPECTATION_FAILED.value();
		
		assertEquals(expected, actual);
	}
	
}
