package com.abeldevelop.architecture.library.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class StringUtilsTests {

	@Test
	public void test_normalize() {
		String expected = "a";
		String actual = StringUtils.normalize("á");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_generateUrlName() {
		String expected = "a-a";
		String actual = StringUtils.generateUrlName("a a");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_createObject() {
		assertThrows(IllegalAccessException.class, () -> new StringUtils());
	}
}
