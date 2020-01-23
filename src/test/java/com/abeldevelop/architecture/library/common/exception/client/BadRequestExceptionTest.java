package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class BadRequestExceptionTest {

	@Test
	public void test_BadRequestException() {
		new BadRequestException("", new ArrayList<Object>());
		new BadRequestException("", new RuntimeException());
		new BadRequestException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new BadRequestException("").getStatus().value();
		int expected = HttpStatus.BAD_REQUEST.value();
		
		assertEquals(expected, actual);
	}
}
