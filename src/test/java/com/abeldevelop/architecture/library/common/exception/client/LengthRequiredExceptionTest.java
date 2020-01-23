package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class LengthRequiredExceptionTest {

	@Test
	public void test_LengthRequiredException() {
		new LengthRequiredException("", new ArrayList<Object>());
		new LengthRequiredException("", new RuntimeException());
		new LengthRequiredException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new LengthRequiredException("").getStatus().value();
		int expected = HttpStatus.LENGTH_REQUIRED.value();
		
		assertEquals(expected, actual);
	}
	
}
