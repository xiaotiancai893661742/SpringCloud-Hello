package com.lyc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/feign")
@EnableHystrix
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/testRibbon")
    @HystrixCommand(fallbackMethod="consumerServiceRibbonFallback")
    public Map<String,Object> testRibbon()  {
        Map<String,Object> result = restTemplate.postForEntity("http://business/business/feign",null, Map.class).getBody();
        return result;
    }

    public Map<String,Object> consumerServiceRibbonFallback() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data","ribbonerror");
        return stringObjectHashMap;

    }

}
