package com.abeldevelop.architecture.library.common.mapper.audit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.abeldevelop.architecture.library.common.domain.audit.Audit;
import com.abeldevelop.architecture.library.common.dto.audit.AuditResponseResource;
import com.abeldevelop.architecture.library.common.model.BaseEntityWithAudit;

public class AuditMapperTest {

	private AuditMapper auditMapper;
	
	@BeforeEach
	public void setUp() {
		auditMapper = new AuditMapper();
	}
	
	@Test
	public void test_mapEntityToDomain() {
		
		LocalDateTime now = LocalDateTime.now();
		
		BaseEntityWithAudit baseEntity = BaseEntityWithAudit.builder()
				.auditCreatedDate(now)
				.auditCreatedUser("createdUser")
				.auditModifiedDate(now)
				.auditModifiedUser("modifiedUser")
				.auditDeletedDate(now)
				.auditDeletedUser("deletedUser")
				.build();
		
		Audit expected = Audit.builder()
				.auditCreatedDate(now)
				.auditCreatedUser("createdUser")
				.auditModifiedDate(now)
				.auditModifiedUser("modifiedUser")
				.auditDeletedDate(now)
				.auditDeletedUser("deletedUser")
				.build();
		
		Audit actual = auditMapper.mapEntityToDomain(baseEntity);
		
		assertEquals(expected.getAuditCreatedDate(), actual.getAuditCreatedDate());
		assertEquals(expected.getAuditCreatedUser(), actual.getAuditCreatedUser());
		assertEquals(expected.getAuditModifiedDate(), actual.getAuditModifiedDate());
		assertEquals(expected.getAuditModifiedUser(), actual.getAuditModifiedUser());
		assertEquals(expected.getAuditDeletedDate(), actual.getAuditDeletedDate());
		assertEquals(expected.getAuditDeletedUser(), actual.getAuditDeletedUser());
	}
	
	@Test
	public void test_mapDomainToResource() {
		
		LocalDateTime now = LocalDateTime.now();
		
		Audit audit = Audit.builder()
				.auditCreatedDate(now)
				.auditCreatedUser("createdUser")
				.auditModifiedDate(now)
				.auditModifiedUser("modifiedUser")
				.auditDeletedDate(now)
				.auditDeletedUser("deletedUser")
				.build();
		
		AuditResponseResource expected = AuditResponseResource.builder()
				.auditCreatedDate(now)
				.auditCreatedUser("createdUser")
				.auditModifiedDate(now)
				.auditModifiedUser("modifiedUser")
				.auditDeletedDate(now)
				.auditDeletedUser("deletedUser")
				.build();
		
		AuditResponseResource actual = auditMapper.mapDomainToResource(audit);
		
		assertEquals(expected.getAuditCreatedDate(), actual.getAuditCreatedDate());
		assertEquals(expected.getAuditCreatedUser(), actual.getAuditCreatedUser());
		assertEquals(expected.getAuditModifiedDate(), actual.getAuditModifiedDate());
		assertEquals(expected.getAuditModifiedUser(), actual.getAuditModifiedUser());
		assertEquals(expected.getAuditDeletedDate(), actual.getAuditDeletedDate());
		assertEquals(expected.getAuditDeletedUser(), actual.getAuditDeletedUser());
	}
}
