package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class UnsupportedMediaTypeExceptionTest {

	@Test
	public void test_UnsupportedMediaTypeException() {
		new UnsupportedMediaTypeException("", new ArrayList<Object>());
		new UnsupportedMediaTypeException("", new RuntimeException());
		new UnsupportedMediaTypeException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new UnsupportedMediaTypeException("").getStatus().value();
		int expected = HttpStatus.UNSUPPORTED_MEDIA_TYPE.value();
		
		assertEquals(expected, actual);
	}
	
}
