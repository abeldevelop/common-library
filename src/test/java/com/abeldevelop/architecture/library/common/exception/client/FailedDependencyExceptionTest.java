package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class FailedDependencyExceptionTest {

	@Test
	public void test_FailedDependencyException() {
		new FailedDependencyException("", new ArrayList<Object>());
		new FailedDependencyException("", new RuntimeException());
		new FailedDependencyException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new FailedDependencyException("").getStatus().value();
		int expected = HttpStatus.FAILED_DEPENDENCY.value();
		
		assertEquals(expected, actual);
	}
	
}
