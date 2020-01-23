package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class InsufficientStorageExceptionTest {

	@Test
	public void test_InsufficientStorageException() {
		new InsufficientStorageException("", new ArrayList<Object>());
		new InsufficientStorageException("", new RuntimeException());
		new InsufficientStorageException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new InsufficientStorageException("").getStatus().value();
		int expected = HttpStatus.INSUFFICIENT_STORAGE.value();
		
		assertEquals(expected, actual);
	}
	
}
