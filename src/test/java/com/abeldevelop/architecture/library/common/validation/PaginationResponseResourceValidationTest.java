package com.abeldevelop.architecture.library.common.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.abeldevelop.architecture.library.common.config.property.ErrorCodeArchitectureProperties;
import com.abeldevelop.architecture.library.common.dto.pagination.PaginationResponseResource;
import com.abeldevelop.architecture.library.common.exception.server.ValidationResponseException;

public class PaginationResponseResourceValidationTest {

	private PaginationResponseResourceValidation paginationResponseResourceValidation;
	
	@BeforeEach
	public void setUp() {
		ErrorCodeArchitectureProperties errorCodeArchitectureProperties = new ErrorCodeArchitectureProperties();
		paginationResponseResourceValidation = new PaginationResponseResourceValidation(errorCodeArchitectureProperties);
	}
	
	@Test
	public void test_areYouTheElement_true() {
		boolean expected = true;
		boolean actual = paginationResponseResourceValidation.areYouTheElement(PaginationResponseResource.class.getCanonicalName());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_areYouTheElement_false() {
		boolean expected = false;
		boolean actual = paginationResponseResourceValidation.areYouTheElement(PaginationResponseResourceValidationTest.class.getCanonicalName());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_validate_ok() {
		PaginationResponseResource paginationResponseResource = PaginationResponseResource.builder()
				.page(1)
				.size(1)
				.numberOfElements(1)
				.totalPages(1)
				.totalElements(1l)
				.first(true)
				.last(true)
				.build();
		
		paginationResponseResourceValidation.validate(paginationResponseResource);
	}
	
	@Test
	public void test_validate_objectNull() {
		PaginationResponseResource paginationResponseResource = null;
		assertThrows(ValidationResponseException.class, () -> paginationResponseResourceValidation.validate(paginationResponseResource));
	}
	
	@Test
	public void test_validate_pageNull() {
		PaginationResponseResource paginationResponseResource = PaginationResponseResource.builder()
				.page(null)
				.size(1)
				.numberOfElements(1)
				.totalPages(1)
				.totalElements(1l)
				.first(true)
				.last(true)
				.build();
		assertThrows(ValidationResponseException.class, () -> paginationResponseResourceValidation.validate(paginationResponseResource));
	}
	
	@Test
	public void test_validate_sizeNull() {
		PaginationResponseResource paginationResponseResource = PaginationResponseResource.builder()
				.page(1)
				.size(null)
				.numberOfElements(1)
				.totalPages(1)
				.totalElements(1l)
				.first(true)
				.last(true)
				.build();
		assertThrows(ValidationResponseException.class, () -> paginationResponseResourceValidation.validate(paginationResponseResource));
	}
	
	@Test
	public void test_validate_numberOfElementsNull() {
		PaginationResponseResource paginationResponseResource = PaginationResponseResource.builder()
				.page(1)
				.size(1)
				.numberOfElements(null)
				.totalPages(1)
				.totalElements(1l)
				.first(true)
				.last(true)
				.build();
		assertThrows(ValidationResponseException.class, () -> paginationResponseResourceValidation.validate(paginationResponseResource));
	}
	
	@Test
	public void test_validate_totalPagesNull() {
		PaginationResponseResource paginationResponseResource = PaginationResponseResource.builder()
				.page(1)
				.size(1)
				.numberOfElements(1)
				.totalPages(null)
				.totalElements(1l)
				.first(true)
				.last(true)
				.build();
		assertThrows(ValidationResponseException.class, () -> paginationResponseResourceValidation.validate(paginationResponseResource));
	}
	
	@Test
	public void test_validate_totalElementsNull() {
		PaginationResponseResource paginationResponseResource = PaginationResponseResource.builder()
				.page(1)
				.size(1)
				.numberOfElements(1)
				.totalPages(1)
				.totalElements(null)
				.first(true)
				.last(true)
				.build();
		assertThrows(ValidationResponseException.class, () -> paginationResponseResourceValidation.validate(paginationResponseResource));
	}
	
	@Test
	public void test_validate_firstNull() {
		PaginationResponseResource paginationResponseResource = PaginationResponseResource.builder()
				.page(1)
				.size(1)
				.numberOfElements(1)
				.totalPages(1)
				.totalElements(1l)
				.first(null)
				.last(true)
				.build();
		assertThrows(ValidationResponseException.class, () -> paginationResponseResourceValidation.validate(paginationResponseResource));
	}
	
	@Test
	public void test_validate_lastNull() {
		PaginationResponseResource paginationResponseResource = PaginationResponseResource.builder()
				.page(1)
				.size(1)
				.numberOfElements(1)
				.totalPages(1)
				.totalElements(1l)
				.first(true)
				.last(null)
				.build();
		assertThrows(ValidationResponseException.class, () -> paginationResponseResourceValidation.validate(paginationResponseResource));
	}
}