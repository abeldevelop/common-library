package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class GatewayTimeoutExceptionTest {

	@Test
	public void test_GatewayTimeoutException() {
		new GatewayTimeoutException("", new ArrayList<Object>());
		new GatewayTimeoutException("", new RuntimeException());
		new GatewayTimeoutException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new GatewayTimeoutException("").getStatus().value();
		int expected = HttpStatus.GATEWAY_TIMEOUT.value();
		
		assertEquals(expected, actual);
	}
	
}
