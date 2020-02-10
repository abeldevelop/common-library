package com.abeldevelop.architecture.library.common.config.property;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.abeldevelop.architecture.library.common.client.configserver.dto.PropertiesResponseResource;
import com.abeldevelop.architecture.library.common.client.configserver.dto.PropertySourcesResponseResource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Profile(value = {"local", "dev", "qa", "pro"})
@RequiredArgsConstructor
@Configuration
public class LogStartUpProperties {

	private final Environment environment;
	private final RestTemplate restTemplate;
	
	@Value("${spring.application.name}")
	private String serviceName;
	
	@Value("${spring.cloud.config.uri}")
	private String configServerUri;
	
	
	@PostConstruct
	public void postConstruct() {
		try {
			showLogs(getProperties());
		} catch (Exception e) {
			log.error("Exception: {}", e);
		}
	}
	
	private void showLogs(PropertiesResponseResource propertiesResponseResource) {
		log.info("******************* START ACTIVE PROPERTIES *******************");
		for(PropertySourcesResponseResource propertySourcesResponseResource : propertiesResponseResource.getPropertySources()) {
			log.info("Start properties in: {}", propertySourcesResponseResource.getName());
			for (Map.Entry<String, String> entry : propertySourcesResponseResource.getSource().entrySet()) {
				if(entry.getKey().contains("password")) {
					log.info("{}={}", entry.getKey(), "**********");
				} else {
					log.info("{}={}", entry.getKey(), environment.getProperty(entry.getKey()));
				}
			}
			log.info("End properties in: {}", propertySourcesResponseResource.getName());
		}
		log.info("******************* END ACTIVE PROPERTIES *******************");
	}
	
	
	private PropertiesResponseResource getProperties() {
		String profile = environment.getActiveProfiles()[0];
		String url = configServerUri + "/" + serviceName + "/" + profile;
		return restTemplate.getForEntity(url, PropertiesResponseResource.class).getBody();
	}
}
