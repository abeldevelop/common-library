package com.abeldevelop.architecture.library.common.config.i18n;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class Translator {

	private ResourceBundleMessageSource messageSource;

	@Autowired
	public Translator(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String translate(String msgCode) {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(msgCode, null, locale);
	}
	
}