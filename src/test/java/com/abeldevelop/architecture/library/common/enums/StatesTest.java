package com.abeldevelop.architecture.library.common.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StatesTest {

	@Test
	public void test_EnabledStates() {
		States actual = States.ENABLED;
		String expected = "ENABLED";
		
		assertEquals(expected, actual.getState());
		assertEquals(expected, actual.toString());
	}
	
	@Test
	public void test_DisabledStates() {
		States actual = States.DISABLED;
		String expected = "DISABLED";
		
		assertEquals(expected, actual.getState());
		assertEquals(expected, actual.toString());
	}
	
	@Test
	public void test_DeletedStates() {
		States actual = States.DELETED;
		String expected = "DELETED";
		
		assertEquals(expected, actual.getState());
		assertEquals(expected, actual.toString());
	}
	
	@Test
	public void test_PendingToDeletedStates() {
		States actual = States.PENDING_TO_DELETED;
		String expected = "PENDING_TO_DELETED";
		
		assertEquals(expected, actual.getState());
		assertEquals(expected, actual.toString());
	}
}
