package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class ProxyAuthenticationRequiredExceptionTest {

	@Test
	public void test_ProxyAuthenticationRequiredException() {
		new ProxyAuthenticationRequiredException("", new ArrayList<Object>());
		new ProxyAuthenticationRequiredException("", new RuntimeException());
		new ProxyAuthenticationRequiredException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new ProxyAuthenticationRequiredException("").getStatus().value();
		int expected = HttpStatus.PROXY_AUTHENTICATION_REQUIRED.value();
		
		assertEquals(expected, actual);
	}
	
}
