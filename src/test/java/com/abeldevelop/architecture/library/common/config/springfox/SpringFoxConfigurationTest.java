package com.abeldevelop.architecture.library.common.config.springfox;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpringFoxConfigurationTest {

	private SpringFoxConfiguration springFoxConfiguration;
	
	@Mock
	private SpringfoxConfigurationProperties springfoxConfigurationProperties;
	
	@BeforeEach
	public void setUp() {
		springFoxConfiguration = new SpringFoxConfiguration(springfoxConfigurationProperties);
	}
	
	@Test
	public void test_ok() {
		Mockito.when(springfoxConfigurationProperties.getApiPackage()).thenReturn("asa");
		SpringfoxContactConfigurationProperties springfoxContactConfigurationProperties = new SpringfoxContactConfigurationProperties();
		Mockito.when(springfoxConfigurationProperties.getTags()).thenReturn(null);
		Mockito.when(springfoxConfigurationProperties.getContact()).thenReturn(springfoxContactConfigurationProperties);
		springFoxConfiguration.apiDocket();
	}
	
	@Test
	public void test02_ok() {
		Mockito.when(springfoxConfigurationProperties.getApiPackage()).thenReturn("asa");
		SpringfoxContactConfigurationProperties springfoxContactConfigurationProperties = new SpringfoxContactConfigurationProperties();
		Map<String, String> tags = new HashMap<String, String>();
		Mockito.when(springfoxConfigurationProperties.getContact()).thenReturn(springfoxContactConfigurationProperties);
		Mockito.when(springfoxConfigurationProperties.getTags()).thenReturn(tags);
		springFoxConfiguration.apiDocket();
	}
	
	@Test
	public void test04_ok() {
		Mockito.when(springfoxConfigurationProperties.getApiPackage()).thenReturn("asa");
		SpringfoxContactConfigurationProperties springfoxContactConfigurationProperties = new SpringfoxContactConfigurationProperties();
		Map<String, String> tags = new HashMap<String, String>();
		tags.put("a", "a");
		Mockito.when(springfoxConfigurationProperties.getTags()).thenReturn(tags);
		Mockito.when(springfoxConfigurationProperties.getContact()).thenReturn(springfoxContactConfigurationProperties);
		springFoxConfiguration.apiDocket();
	}
	
	@Test
	public void test05_ok() {
		Mockito.when(springfoxConfigurationProperties.getApiPackage()).thenReturn("asa");
		SpringfoxContactConfigurationProperties springfoxContactConfigurationProperties = new SpringfoxContactConfigurationProperties();
		Map<String, String> tags = new HashMap<String, String>();
		tags.put("a", "a");
		tags.put("b", "b");
		Mockito.when(springfoxConfigurationProperties.getTags()).thenReturn(tags);
		Mockito.when(springfoxConfigurationProperties.getContact()).thenReturn(springfoxContactConfigurationProperties);
		springFoxConfiguration.apiDocket();
	}
}
