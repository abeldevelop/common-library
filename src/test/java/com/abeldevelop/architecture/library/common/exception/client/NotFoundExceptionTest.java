package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class NotFoundExceptionTest {

	@Test
	public void test_NotFoundException() {
		new NotFoundException("", new ArrayList<Object>());
		new NotFoundException("", new RuntimeException());
		new NotFoundException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new NotFoundException("").getStatus().value();
		int expected = HttpStatus.NOT_FOUND.value();
		
		assertEquals(expected, actual);
	}
	
}
