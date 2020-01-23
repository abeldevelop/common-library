package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class GoneExceptionTest {

	@Test
	public void test_GoneException() {
		new GoneException("", new ArrayList<Object>());
		new GoneException("", new RuntimeException());
		new GoneException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new GoneException("").getStatus().value();
		int expected = HttpStatus.GONE.value();
		
		assertEquals(expected, actual);
	}
	
}
