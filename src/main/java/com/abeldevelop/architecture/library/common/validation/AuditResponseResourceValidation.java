package com.abeldevelop.architecture.library.common.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.constant.ErrorAuditCodeMessageConstants;
import com.abeldevelop.architecture.library.common.dto.audit.AuditResponseResource;
import com.abeldevelop.architecture.library.common.exception.server.ValidationResponseException;
import com.abeldevelop.architecture.library.common.factory.validation.ValidationResource;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AuditResponseResourceValidation implements ValidationResource {

    @Override
    public boolean areYouTheElement(String elementName) {
        return AuditResponseResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationResponseException(ErrorAuditCodeMessageConstants.AUDIT_RESPONSE_RESOURCE_NOT_NULL);
        }
        AuditResponseResource auditResponseResource = (AuditResponseResource) toValidate;
        validateAuditCreatedDate(auditResponseResource);
        validateAuditCreatedUser(auditResponseResource);
    }

    private void validateAuditCreatedDate(AuditResponseResource auditResponseResource) {
        if(auditResponseResource.getAuditCreatedDate() == null) {
            throw new ValidationResponseException(ErrorAuditCodeMessageConstants.AUDIT_CREATED_DATE_NOT_NULL);
        }
    }
    
    private void validateAuditCreatedUser(AuditResponseResource auditResponseResource) {
        if(auditResponseResource.getAuditCreatedUser() == null) {
            throw new ValidationResponseException(ErrorAuditCodeMessageConstants.AUDIT_CREATED_USER_NOT_NULL);
        }
    }
    
}