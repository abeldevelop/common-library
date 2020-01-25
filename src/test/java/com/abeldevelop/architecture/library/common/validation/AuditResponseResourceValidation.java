package com.abeldevelop.architecture.library.common.validation;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.config.property.ErrorCodeArchitectureProperties;
import com.abeldevelop.architecture.library.common.dto.audit.AuditResponseResource;
import com.abeldevelop.architecture.library.common.exception.server.ValidationResponseException;
import com.abeldevelop.architecture.library.common.factory.validation.ValidationResource;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AuditResponseResourceValidation implements ValidationResource {

    private final ErrorCodeArchitectureProperties errorCodeArchitectureProperties;
    
    @Override
    public boolean areYouTheElement(String elementName) {
        return AuditResponseResource.class.getCanonicalName().equals(elementName);
    }

    @Override
    public void validate(Object toValidate) {
        if(toValidate == null) {
            throw new ValidationResponseException(errorCodeArchitectureProperties.getAuditResponseResourceNotNull());
        }
        AuditResponseResource auditResponseResource = (AuditResponseResource) toValidate;
        validateAuditCreatedDate(auditResponseResource);
        validateAuditCreatedUser(auditResponseResource);
    }

    private void validateAuditCreatedDate(AuditResponseResource auditResponseResource) {
        if(auditResponseResource.getAuditCreatedDate() == null) {
            throw new ValidationResponseException(errorCodeArchitectureProperties.getAuditCreatedDateNotNull());
        }
    }
    
    private void validateAuditCreatedUser(AuditResponseResource auditResponseResource) {
        if(auditResponseResource.getAuditCreatedUser() == null) {
            throw new ValidationResponseException(errorCodeArchitectureProperties.getAuditCreatedUserNotNull());
        }
    }
    
}