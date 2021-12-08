package com.lyc.filter;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class MyFallbackProvider implements FallbackProvider {
    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return null;
    }

    @Override
    public String getRoute() {
        //针对那些服务熔断
        return "business";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return null;
    }
}
