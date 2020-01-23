package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class NetworkAuthenticationRequiredExceptionTest {

	@Test
	public void test_NetworkAuthenticationRequiredException() {
		new NetworkAuthenticationRequiredException("", new ArrayList<Object>());
		new NetworkAuthenticationRequiredException("", new RuntimeException());
		new NetworkAuthenticationRequiredException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new NetworkAuthenticationRequiredException("").getStatus().value();
		int expected = HttpStatus.NETWORK_AUTHENTICATION_REQUIRED.value();
		
		assertEquals(expected, actual);
	}
	
}
