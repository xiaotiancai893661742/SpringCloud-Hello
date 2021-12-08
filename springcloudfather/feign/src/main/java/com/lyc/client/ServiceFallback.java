package com.lyc.client;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class ServiceFallback implements BusinessClient {
    @Override
    public Map<String, Object> feign() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data","调用服务失败");
        return stringObjectHashMap;
    }
}
