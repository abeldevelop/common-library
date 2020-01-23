package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class PaymentRequiredExceptionTest {

	@Test
	public void test_PaymentRequiredException() {
		new PaymentRequiredException("", new ArrayList<Object>());
		new PaymentRequiredException("", new RuntimeException());
		new PaymentRequiredException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new PaymentRequiredException("").getStatus().value();
		int expected = HttpStatus.PAYMENT_REQUIRED.value();
		
		assertEquals(expected, actual);
	}
	
}
