package com.abeldevelop.architecture.library.common.config.i18n;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.abeldevelop.architecture.library.common.constant.ErrorCommonCodeMessageConstants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class Translator {

	private final CustomReloadableResourceBundleMessageSource customReloadableResourceBundleMessageSource;
	
	public String translate(String code) {
		Locale locale = LocaleContextHolder.getLocale();
		try {
			return customReloadableResourceBundleMessageSource.getMessage(code, null, locale);
		} catch (Exception e) {
			log.error("Exception: {}", e);
			return customReloadableResourceBundleMessageSource.getMessage(ErrorCommonCodeMessageConstants.I_18_N_MESSAGE_NOT_FOUND, null, locale);
		}
	}
	
}