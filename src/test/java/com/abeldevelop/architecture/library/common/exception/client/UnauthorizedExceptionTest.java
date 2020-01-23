package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class UnauthorizedExceptionTest {

	@Test
	public void test_UnauthorizedException() {
		new UnauthorizedException("", new ArrayList<Object>());
		new UnauthorizedException("", new RuntimeException());
		new UnauthorizedException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new UnauthorizedException("").getStatus().value();
		int expected = HttpStatus.UNAUTHORIZED.value();
		
		assertEquals(expected, actual);
	}
	
}
