package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class LockedExceptionTest {

	@Test
	public void test_LockedException() {
		new LockedException("", new ArrayList<Object>());
		new LockedException("", new RuntimeException());
		new LockedException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new LockedException("").getStatus().value();
		int expected = HttpStatus.LOCKED.value();
		
		assertEquals(expected, actual);
	}
	
}
