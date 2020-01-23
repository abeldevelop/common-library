package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class NotImplementedExceptionTest {

	@Test
	public void test_NotImplementedException() {
		new NotImplementedException("", new ArrayList<Object>());
		new NotImplementedException("", new RuntimeException());
		new NotImplementedException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new NotImplementedException("").getStatus().value();
		int expected = HttpStatus.NOT_IMPLEMENTED.value();
		
		assertEquals(expected, actual);
	}
	
}
