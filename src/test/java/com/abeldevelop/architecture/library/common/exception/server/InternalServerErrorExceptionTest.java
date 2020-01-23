package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class InternalServerErrorExceptionTest {

	@Test
	public void test_InternalServerErrorException() {
		new InternalServerErrorException("", new ArrayList<Object>());
		new InternalServerErrorException("", new RuntimeException());
		new InternalServerErrorException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new InternalServerErrorException("").getStatus().value();
		int expected = HttpStatus.INTERNAL_SERVER_ERROR.value();
		
		assertEquals(expected, actual);
	}
	
}
