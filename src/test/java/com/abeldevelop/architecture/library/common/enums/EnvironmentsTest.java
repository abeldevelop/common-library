package com.abeldevelop.architecture.library.common.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EnvironmentsTest {

	@Test
	public void test_LocalEnvironment() {
		Environments actual = Environments.LOCAL;
		String expected = "local";
		
		assertEquals(expected, actual.getEnvironment());
		assertEquals(expected, actual.toString());
	}
	
	@Test
	public void test_DEVEnvironment() {
		Environments actual = Environments.DEV;
		String expected = "dev";
		
		assertEquals(expected, actual.getEnvironment());
		assertEquals(expected, actual.toString());
	}
	
	@Test
	public void test_QAEnvironment() {
		Environments actual = Environments.QA;
		String expected = "qa";
		
		assertEquals(expected, actual.getEnvironment());
		assertEquals(expected, actual.toString());
	}
	
	@Test
	public void test_PROEnvironment() {
		Environments actual = Environments.PRO;
		String expected = "pro";
		
		assertEquals(expected, actual.getEnvironment());
		assertEquals(expected, actual.toString());
	}
}
