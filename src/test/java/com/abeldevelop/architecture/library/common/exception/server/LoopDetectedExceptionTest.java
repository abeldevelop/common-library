package com.abeldevelop.architecture.library.common.exception.server;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class LoopDetectedExceptionTest {

	@Test
	public void test_LoopDetectedException() {
		new LoopDetectedException("", new ArrayList<Object>());
		new LoopDetectedException("", new RuntimeException());
		new LoopDetectedException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new LoopDetectedException("").getStatus().value();
		int expected = HttpStatus.LOOP_DETECTED.value();
		
		assertEquals(expected, actual);
	}
	
}
