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

	private String paginationMinPageError;
    private String paginationMinSizeError;
    
    private String requestFieldValueNotValid;
    
}
