package com.abeldevelop.architecture.library.common.service;

import com.abeldevelop.architecture.library.common.constant.ErrorCommonCodeMessageConstants;
import com.abeldevelop.architecture.library.common.exception.client.ConflictException;
import com.abeldevelop.architecture.library.common.model.BaseEntityWithAudit;
import com.abeldevelop.architecture.library.common.util.AuditUtils;

/**
 * Abstract class to implements all Services of the architecture.
 * 
 * @since 1.0.0
 */
public abstract class CommonService {

	public void checkNotExistConflict(Integer databaseVersion, Integer dtoVersion) {
		if(databaseVersion == null || dtoVersion == null || databaseVersion.intValue() != dtoVersion.intValue()) {
			throw new ConflictException(ErrorCommonCodeMessageConstants.VERSION_CONFLICT);
		}
	}
	
    /**
     * Fill audit data.
     *
     * @param auditType the audit type
     * @param baseEntity the base entity
     * @param user the user
     * 
     * @since 1.0.0
     */
    public void fillAuditData(AuditUtils.AuditType auditType, BaseEntityWithAudit baseEntity, String user) {
        AuditUtils.fillAuditData(auditType, baseEntity, "user");
    }
    
    /**
     * Fill audit data.
     *
     * @param auditType the audit type
     * @param baseEntity the base entity
     * 
     * @since 1.0.0
     */
    public void fillAuditData(AuditUtils.AuditType auditType, BaseEntityWithAudit baseEntity) {
        fillAuditData(auditType, baseEntity, "user");
    }
    
}
