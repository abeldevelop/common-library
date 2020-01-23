package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class UnprocessableEntityExceptionTest {

	@Test
	public void test_UnprocessableEntityException() {
		new UnprocessableEntityException("", new ArrayList<Object>());
		new UnprocessableEntityException("", new RuntimeException());
		new UnprocessableEntityException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new UnprocessableEntityException("").getStatus().value();
		int expected = HttpStatus.UNPROCESSABLE_ENTITY.value();
		
		assertEquals(expected, actual);
	}
	
}
