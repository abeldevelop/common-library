package com.abeldevelop.architecture.library.common.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.abeldevelop.architecture.library.common.model.BaseEntityWithAudit;

public class AuditUtilsTest {

	@Test
	public void test_createObject() {
		assertThrows(IllegalAccessException.class, () -> new AuditUtils());
	}
	
	@Test
	public void test_fillCreatedAuditData() {
		BaseEntityWithAudit actual = new BaseEntityWithAudit();
		BaseEntityWithAudit expected = BaseEntityWithAudit.builder().auditCreatedUser("user").build();
		AuditUtils.fillAuditData(AuditUtils.AuditType.CREATED, actual, "user");
		
		assertNotNull(actual.getAuditCreatedDate());
		assertEquals(expected.getAuditCreatedUser(), actual.getAuditCreatedUser());
	}
	
	@Test
	public void test_fillModifiedAuditData() {
		BaseEntityWithAudit actual = new BaseEntityWithAudit();
		BaseEntityWithAudit expected = BaseEntityWithAudit.builder().auditModifiedUser("user").build();
		AuditUtils.fillAuditData(AuditUtils.AuditType.MODIFIED, actual, "user");
		
		assertNotNull(actual.getAuditModifiedDate());
		assertNull(actual.getAuditDeletedDate());
		assertNull(actual.getAuditDeletedUser());
		assertEquals(expected.getAuditModifiedUser(), actual.getAuditModifiedUser());
	}
	
	@Test
	public void test_fillDeletedAuditData() {
		BaseEntityWithAudit actual = new BaseEntityWithAudit();
		BaseEntityWithAudit expected = BaseEntityWithAudit.builder().auditModifiedUser("user").auditDeletedUser("user").build();
		AuditUtils.fillAuditData(AuditUtils.AuditType.DELETED, actual, "user");
		
		assertNotNull(actual.getAuditModifiedDate());
		assertNotNull(actual.getAuditDeletedDate());
		assertNotNull(actual.getAuditDeletedUser());
		assertEquals(expected.getAuditModifiedUser(), actual.getAuditModifiedUser());
		assertEquals(expected.getAuditDeletedUser(), actual.getAuditDeletedUser());
	}
	
	@Test
	public void test_AuditTypeEnum() {
		AuditUtils.AuditType.CREATED.getType();
	}
	
}
