package com.abeldevelop.architecture.library.common.service;

import com.abeldevelop.architecture.library.common.model.BaseEntityWithAudit;
import com.abeldevelop.architecture.library.common.util.AuditUtils;

/**
 * Abstract class to implements all Services of the architecture.
 * 
 * @since 1.0.0
 */
public class CommonService {

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
