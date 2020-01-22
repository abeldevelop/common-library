package com.abeldevelop.architecture.library.common.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CommonFactoryTest {

	@Test
	public void test_getElement_elements_null() {
		List<CommonFactoryElement> elements = null;
		CommonFactoryTestImplementation commonFactory = new CommonFactoryTestImplementation(elements);
		
		boolean expected = false;
		boolean actual = commonFactory.getElement(null).isPresent();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_getElement_elements_empty() {
		List<CommonFactoryElement> elements = new ArrayList<CommonFactoryElement>();
		CommonFactoryTestImplementation commonFactory = new CommonFactoryTestImplementation(elements);
		
		boolean expected = false;
		boolean actual = commonFactory.getElement(null).isPresent();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_getElement_elements_not_found() {
		List<CommonFactoryElement> elements = new ArrayList<CommonFactoryElement>();
		elements.add(new CommonFactoryTestElement());
		CommonFactoryTestImplementation commonFactory = new CommonFactoryTestImplementation(elements);
		
		boolean expected = false;
		boolean actual = commonFactory.getElement(null).isPresent();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_getElement_elements_found() {
		List<CommonFactoryElement> elements = new ArrayList<CommonFactoryElement>();
		elements.add(new CommonFactoryTestElement2());
		elements.add(new CommonFactoryTestElement());
		CommonFactoryTestImplementation commonFactory = new CommonFactoryTestImplementation(elements);
		
		boolean expected = true;
		boolean actual = commonFactory.getElement("elementName").isPresent();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_02_getElement_elements_found() {
		List<CommonFactoryElement> elements = new ArrayList<CommonFactoryElement>();
		elements.add(new CommonFactoryTestElement());
		elements.add(new CommonFactoryTestElement2());
		CommonFactoryTestImplementation commonFactory = new CommonFactoryTestImplementation(elements);
		
		boolean expected = true;
		boolean actual = commonFactory.getElement("elementName").isPresent();
		
		assertEquals(expected, actual);
	}
	
	public class CommonFactoryTestImplementation extends CommonFactory<CommonFactoryElement> {

		public CommonFactoryTestImplementation(List<CommonFactoryElement> elements) {
			super(elements);
		}
	}
	
	public class CommonFactoryTestElement implements CommonFactoryElement {
		
		@Override
		public boolean areYouTheElement(String elementName) {
			return "elementName".equals(elementName);
		}
	}
	
	public class CommonFactoryTestElement2 implements CommonFactoryElement {
		
		@Override
		public boolean areYouTheElement(String elementName) {
			return "element".equals(elementName);
		}
	}

	
}
