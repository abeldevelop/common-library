package com.abeldevelop.architecture.library.common.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.client.errormessage.ErrorMessageClient;
import com.abeldevelop.architecture.library.common.client.errormessage.dto.ErrorMessageResponseResource;
import com.abeldevelop.architecture.library.common.service.ErrorMessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class ErrorMessageServiceImpl implements ErrorMessageService {

	private final ErrorMessageClient errorMessageClient;

	@Value("${spring.application.name}")
	private String serviceName;

	@Override
	public Optional<String> getMessage(String code) {
		return callLabelsAndErrorsService(code);
	}

	private Optional<String> callLabelsAndErrorsService(String code) {
		try {
			String message = null;
			// TODO => Get the languageCode from headers
			ErrorMessageResponseResource errorMessageResponseResource = errorMessageClient.executeFindOne(serviceName, "es-ES", code);
			message = errorMessageResponseResource.getMessage();
			return Optional.ofNullable(message);
		} catch (Exception e) {
			log.error("Exception: {}", e);
		}
		return Optional.ofNullable(code);
	}
	
}
