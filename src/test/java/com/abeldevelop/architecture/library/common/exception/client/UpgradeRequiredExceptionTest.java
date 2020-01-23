package com.abeldevelop.architecture.library.common.exception.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class UpgradeRequiredExceptionTest {

	@Test
	public void test_UpgradeRequiredException() {
		new UpgradeRequiredException("", new ArrayList<Object>());
		new UpgradeRequiredException("", new RuntimeException());
		new UpgradeRequiredException("", new ArrayList<Object>(), new RuntimeException());
		int actual = new UpgradeRequiredException("").getStatus().value();
		int expected = HttpStatus.UPGRADE_REQUIRED.value();
		
		assertEquals(expected, actual);
	}
	
}
