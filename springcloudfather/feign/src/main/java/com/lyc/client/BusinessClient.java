package com.lyc.client;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Component
@FeignClient(value = "business",fallback = ServiceFallback.class)
public interface BusinessClient {

    @PostMapping(value = "/business/feign")
    Map<String, Object> feign() ;
}
