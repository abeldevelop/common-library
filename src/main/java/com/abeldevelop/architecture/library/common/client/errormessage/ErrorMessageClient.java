package com.abeldevelop.architecture.library.common.client.errormessage;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abeldevelop.architecture.library.common.client.errormessage.dto.ErrorMessageResponseResource;

@FeignClient("labels-and-errors-service")
public interface ErrorMessageClient {

    @GetMapping("/v1/error-message/find-one")
    public ErrorMessageResponseResource executeFindOne(
            @RequestParam(name = "service-name", required = true) String serviceName, 
            @RequestParam(name = "language-code", required = true) String languageCode, 
            @RequestParam(name = "code", required = true) String code);
    
}