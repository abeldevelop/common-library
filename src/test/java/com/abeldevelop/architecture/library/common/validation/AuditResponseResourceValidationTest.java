package com.abeldevelop.architecture.library.common.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.abeldevelop.architecture.library.common.config.property.ErrorCodeArchitectureProperties;
import com.abeldevelop.architecture.library.common.dto.audit.AuditResponseResource;
import com.abeldevelop.architecture.library.common.exception.server.ValidationResponseException;

public class AuditResponseResourceValidationTest {

	private AuditResponseResourceValidation auditResponseResourceValidation;
	
	@BeforeEach
	public void setUp() {
		ErrorCodeArchitectureProperties errorCodeArchitectureProperties = new ErrorCodeArchitectureProperties();
		auditResponseResourceValidation = new AuditResponseResourceValidation(errorCodeArchitectureProperties);
	}
	
	@Test
	public void test_areYouTheElement_true() {
		boolean expected = true;
		boolean actual = auditResponseResourceValidation.areYouTheElement(AuditResponseResource.class.getCanonicalName());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_areYouTheElement_false() {
		boolean expected = false;
		boolean actual = auditResponseResourceValidation.areYouTheElement(AuditResponseResourceValidationTest.class.getCanonicalName());
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_validate_ok() {
		AuditResponseResource auditResponseResource = AuditResponseResource.builder()
				.auditCreatedDate(LocalDateTime.now())
				.auditCreatedUser("user")
				.build();
		
		auditResponseResourceValidation.validate(auditResponseResource);
	}
	
	@Test
	public void test_validate_objectNull() {
		AuditResponseResource auditResponseResource = null;
		assertThrows(ValidationResponseException.class, () -> auditResponseResourceValidation.validate(auditResponseResource));
	}
	
	@Test
	public void test_validate_auditCreatedDateNull() {
		AuditResponseResource auditResponseResource = AuditResponseResource.builder()
				.auditCreatedDate(null)
				.auditCreatedUser("user")
				.build();
		assertThrows(ValidationResponseException.class, () -> auditResponseResourceValidation.validate(auditResponseResource));
	}
	
	@Test
	public void test_validate_auditCreatedUserNull() {
		AuditResponseResource auditResponseResource = AuditResponseResource.builder()
				.auditCreatedDate(LocalDateTime.now())
				.auditCreatedUser(null)
				.build();
		assertThrows(ValidationResponseException.class, () -> auditResponseResourceValidation.validate(auditResponseResource));
	}
}