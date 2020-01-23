package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class PreconditionRequiredExceptionTest {

	@Test
	public void test_PreconditionRequiredException() {
		new PreconditionRequiredException("", new ArrayList<Object>());
		new PreconditionRequiredException("", new RuntimeException());
		new PreconditionRequiredException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new PreconditionRequiredException("").getStatus().value();
		int expected = HttpStatus.PRECONDITION_REQUIRED.value();
		
		assertEquals(expected, actual);
	}
	
}
