package com.abeldevelop.architecture.library.common.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
@ConfigurationProperties("architecture-error-code")
public class ErrorCodeArchitectureProperties {
    
	private String requestFieldValueNotValid;
    
	//Pagination
	private String paginationResponseResourceNotNull;
	private String paginationMinPageError;
	private String paginationMinSizeError;
	private String paginationPageNotNull;
	private String paginationSizeNotNull;
	private String paginationNumberOfElementsNotNull;
	private String paginationTotalPagesNotNull;
	private String paginationTotalElementsNotNull;
	private String paginationFirstNotNull;
	private String paginationLastNotNull;

	//Audit
	private String auditResponseResourceNotNull;
	private String auditCreatedDateNotNull;
	private String auditCreatedUserNotNull;
	
	//Service
	private String versionConflict;
}
