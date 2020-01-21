package com.abeldevelop.architecture.library.common.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class BaseEntityWithAuditAndVersionTest {

	
	@Test
	public void test_createdBaseEntityWithAuditAndVersionObject_ok() {
		BaseEntityWithAuditAndVersion expected = new BaseEntityWithAuditAndVersion();
		expected.setId(1L);
		expected.setAuditCreatedDate(LocalDateTime.of(2020, 01, 22, 22, 22));
		expected.setAuditCreatedUser("userCreated");
		expected.setAuditModifiedDate(LocalDateTime.of(2020, 01, 22, 22, 22));
		expected.setAuditModifiedUser("userModified");
		expected.setAuditDeletedDate(LocalDateTime.of(2020, 01, 22, 22, 22));
		expected.setAuditDeletedUser("userDeleted");
		expected.setVersion(2);
		
		BaseEntityWithAuditAndVersion actual = BaseEntityWithAuditAndVersion.builder()
			.id(1L)
			.auditCreatedDate(LocalDateTime.of(2020, 01, 22, 22, 22))
			.auditCreatedUser("userCreated")
			.auditModifiedDate(LocalDateTime.of(2020, 01, 22, 22, 22))
			.auditModifiedUser("userModified")
			.auditDeletedDate(LocalDateTime.of(2020, 01, 22, 22, 22))
			.auditDeletedUser("userDeleted")
			.version(2)
			.build();
		
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getAuditCreatedDate(), actual.getAuditCreatedDate());
		assertEquals(expected.getAuditCreatedUser(), actual.getAuditCreatedUser());
		assertEquals(expected.getAuditModifiedDate(), actual.getAuditModifiedDate());
		assertEquals(expected.getAuditModifiedUser(), actual.getAuditModifiedUser());
		assertEquals(expected.getAuditDeletedDate(), actual.getAuditDeletedDate());
		assertEquals(expected.getAuditDeletedUser(), actual.getAuditDeletedUser());
		assertEquals(expected.getVersion(), actual.getVersion());
		
	}
}
