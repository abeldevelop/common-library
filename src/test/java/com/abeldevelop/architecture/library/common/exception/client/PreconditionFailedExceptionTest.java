package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class PreconditionFailedExceptionTest {

	@Test
	public void test_PreconditionFailedException() {
		new PreconditionFailedException("", new ArrayList<Object>());
		new PreconditionFailedException("", new RuntimeException());
		new PreconditionFailedException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new PreconditionFailedException("").getStatus().value();
		int expected = HttpStatus.PRECONDITION_FAILED.value();
		
		assertEquals(expected, actual);
	}
	
}
