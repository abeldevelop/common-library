package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class UnavailableForLegalReasonsExceptionTest {

	@Test
	public void test_UnavailableForLegalReasonsException() {
		new UnavailableForLegalReasonsException("", new ArrayList<Object>());
		new UnavailableForLegalReasonsException("", new RuntimeException());
		new UnavailableForLegalReasonsException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new UnavailableForLegalReasonsException("").getStatus().value();
		int expected = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS.value();
		
		assertEquals(expected, actual);
	}
	
}
