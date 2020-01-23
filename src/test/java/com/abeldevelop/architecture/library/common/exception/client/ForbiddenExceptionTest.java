package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class ForbiddenExceptionTest {

	@Test
	public void test_ForbiddenException() {
		new ForbiddenException("", new ArrayList<Object>());
		new ForbiddenException("", new RuntimeException());
		new ForbiddenException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new ForbiddenException("").getStatus().value();
		int expected = HttpStatus.FORBIDDEN.value();
		
		assertEquals(expected, actual);
	}
	
}
