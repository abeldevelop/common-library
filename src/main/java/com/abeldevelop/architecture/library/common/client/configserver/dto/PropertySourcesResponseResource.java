package com.abeldevelop.architecture.library.common.client.configserver.dto;

import java.util.Map;

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
public class PropertySourcesResponseResource {

	private String name;
	private Map<String, String> source;
	
}
