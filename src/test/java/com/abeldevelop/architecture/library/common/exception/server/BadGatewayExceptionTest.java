package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class BadGatewayExceptionTest {

	@Test
	public void test_BadGatewayException() {
		new BadGatewayException("", new ArrayList<Object>());
		new BadGatewayException("", new RuntimeException());
		new BadGatewayException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new BadGatewayException("").getStatus().value();
		int expected = HttpStatus.BAD_GATEWAY.value();
		
		assertEquals(expected, actual);
	}
	
}
