package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class BandwidthLimitExceededExceptionTest {

	@Test
	public void test_BandwidthLimitExceededException() {
		new BandwidthLimitExceededException("", new ArrayList<Object>());
		new BandwidthLimitExceededException("", new RuntimeException());
		new BandwidthLimitExceededException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new BandwidthLimitExceededException("").getStatus().value();
		int expected = HttpStatus.BANDWIDTH_LIMIT_EXCEEDED.value();
		
		assertEquals(expected, actual);
	}
	
}
