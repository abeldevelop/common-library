package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class NotExtendedExceptionTest {

	@Test
	public void test_NotExtendedException() {
		new NotExtendedException("", new ArrayList<Object>());
		new NotExtendedException("", new RuntimeException());
		new NotExtendedException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new NotExtendedException("").getStatus().value();
		int expected = HttpStatus.NOT_EXTENDED.value();
		
		assertEquals(expected, actual);
	}
	
}
