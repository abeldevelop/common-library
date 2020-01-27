package com.abeldevelop.architecture.library.common.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.service.ErrorMessageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ErrorMessageServiceImpl implements ErrorMessageService {

	@Override
	public Optional<String> getMessage(String code) {
		return Optional.ofNullable(code);
	}
}
