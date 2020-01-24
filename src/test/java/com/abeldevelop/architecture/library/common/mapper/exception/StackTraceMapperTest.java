package com.abeldevelop.architecture.library.common.mapper.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.abeldevelop.architecture.library.common.exception.server.BadGatewayException;

public class StackTraceMapperTest {

	@Test
	public void test_map() {
		BadGatewayException badGatewayException = new BadGatewayException("");
		List<String> actual = new StackTraceMapper().map(badGatewayException.getStackTrace());
		System.out.println(actual);
		List<String> expected = Arrays.asList("com.abeldevelop.architecture.library.common.mapper.exception.StackTraceMapperTest:16");
		
		assertEquals(expected.get(0), actual.get(0));
	}
	
}
