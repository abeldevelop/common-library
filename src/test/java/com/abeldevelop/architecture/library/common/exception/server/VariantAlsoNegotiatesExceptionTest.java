package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class VariantAlsoNegotiatesExceptionTest {

	@Test
	public void test_VariantAlsoNegotiatesException() {
		new VariantAlsoNegotiatesException("", new ArrayList<Object>());
		new VariantAlsoNegotiatesException("", new RuntimeException());
		new VariantAlsoNegotiatesException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new VariantAlsoNegotiatesException("").getStatus().value();
		int expected = HttpStatus.VARIANT_ALSO_NEGOTIATES.value();
		
		assertEquals(expected, actual);
	}
	
}
