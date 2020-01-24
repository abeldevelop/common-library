package com.abeldevelop.architecture.library.common.service;

import java.util.Optional;

public interface ErrorMessageService {

	public Optional<String> getMessage(String code);
	
}
