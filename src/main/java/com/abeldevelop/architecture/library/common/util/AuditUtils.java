package com.abeldevelop.architecture.library.common.util;

import java.time.LocalDateTime;

import com.abeldevelop.architecture.library.common.model.BaseEntityWithAudit;

public class AuditUtils {

	protected AuditUtils() throws IllegalAccessException {
		throw new IllegalAccessException();
    }

	public static void fillAuditData(AuditType auditType, BaseEntityWithAudit baseEntityWithAudit, String user) {
        switch (auditType) {
            case CREATED:
                fillCreatedAuditData(baseEntityWithAudit, user);
                break;
            case MODIFIED:
                fillModifiedAuditData(baseEntityWithAudit, user);
                break;
            case DELETED:
                fillDeletedAuditData(baseEntityWithAudit, user);
                break;
        }
    }
    
    private static void fillCreatedAuditData(BaseEntityWithAudit baseEntityWithAudit, String user) {
    	baseEntityWithAudit.setAuditCreatedDate(LocalDateTime.now());
    	baseEntityWithAudit.setAuditCreatedUser(user);
    }
    
    private static void fillModifiedAuditData(BaseEntityWithAudit baseEntityWithAudit, String user) {
    	baseEntityWithAudit.setAuditModifiedDate(LocalDateTime.now());
        baseEntityWithAudit.setAuditModifiedUser(user);
        baseEntityWithAudit.setAuditDeletedDate(null);
        baseEntityWithAudit.setAuditDeletedUser(null);
    }

    private static void fillDeletedAuditData(BaseEntityWithAudit baseEntityWithAudit, String user) {
    	baseEntityWithAudit.setAuditModifiedDate(LocalDateTime.now());
    	baseEntityWithAudit.setAuditModifiedUser(user);
    	baseEntityWithAudit.setAuditDeletedDate(LocalDateTime.now());
    	baseEntityWithAudit.setAuditDeletedUser(user);
    }
    
    public enum AuditType {
        CREATED("CREATED"),
        MODIFIED("MODIFIED"),
        DELETED("DELETED")
        ;
        
        private String value;
        
        private AuditType(String value) {
            this.value = value;
        }
        
        public String getType() {
            return value;
        }
    }
}
