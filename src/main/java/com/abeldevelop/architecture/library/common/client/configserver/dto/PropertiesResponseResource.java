package com.abeldevelop.architecture.library.common.client.configserver.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PropertiesResponseResource {

	private String name;
	private List<String> profiles;
	private List<PropertySourcesResponseResource> propertySources;
	
}
