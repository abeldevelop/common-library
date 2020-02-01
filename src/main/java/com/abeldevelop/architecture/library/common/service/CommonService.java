package com.abeldevelop.architecture.library.common.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.abeldevelop.architecture.library.common.config.property.ErrorCodeArchitectureProperties;
import com.abeldevelop.architecture.library.common.exception.client.ConflictException;

public abstract class CommonService {

	@Autowired
	private ErrorCodeArchitectureProperties errorCodeArchitectureProperties;
	
	public void checkNotExistConflict(Integer databaseVersion, Integer dtoVersion) {
		if(databaseVersion == null || dtoVersion == null || databaseVersion.intValue() != dtoVersion.intValue()) {
			throw new ConflictException(errorCodeArchitectureProperties.getVersionConflict());
		}
	}
	
}
