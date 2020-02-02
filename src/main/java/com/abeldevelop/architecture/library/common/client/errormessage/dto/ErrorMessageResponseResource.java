package com.abeldevelop.architecture.library.common.client.errormessage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class ErrorMessageResponseResource {

    private Long id;
    private String serviceName;
    private String languageCode;
    private String code;
    private String message;
    
}