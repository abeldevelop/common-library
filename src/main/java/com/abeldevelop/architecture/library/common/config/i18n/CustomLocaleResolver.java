package com.abeldevelop.architecture.library.common.config.i18n;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

	private List<Locale> locales = Arrays.asList(new Locale("es"), new Locale("en"));

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String headerLang = request.getHeader("Accept-Language");
		return headerLang == null || headerLang.isEmpty() ? Locale.getDefault() : Locale.lookup(Locale.LanguageRange.parse(headerLang), locales);
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("i18n/messages");
		resourceBundleMessageSource.setDefaultEncoding("UTF-8");
		resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);
		return resourceBundleMessageSource;
	}
	
}