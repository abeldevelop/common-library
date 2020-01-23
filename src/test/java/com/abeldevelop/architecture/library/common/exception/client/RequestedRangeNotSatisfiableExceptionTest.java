package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class RequestedRangeNotSatisfiableExceptionTest {

	@Test
	public void test_RequestedRangeNotSatisfiableException() {
		new RequestedRangeNotSatisfiableException("", new ArrayList<Object>());
		new RequestedRangeNotSatisfiableException("", new RuntimeException());
		new RequestedRangeNotSatisfiableException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new RequestedRangeNotSatisfiableException("").getStatus().value();
		int expected = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE.value();
		
		assertEquals(expected, actual);
	}
	
}
