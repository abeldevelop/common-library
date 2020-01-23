package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class IAmaTeapotExceptionTest {

	@Test
	public void test_IAmaTeapotException() {
		new IAmaTeapotException("", new ArrayList<Object>());
		new IAmaTeapotException("", new RuntimeException());
		new IAmaTeapotException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new IAmaTeapotException("").getStatus().value();
		int expected = HttpStatus.I_AM_A_TEAPOT.value();
		
		assertEquals(expected, actual);
	}
	
}
