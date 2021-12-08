package com.lyc.controller;


import com.lyc.client.BusinessClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/feign")
public class HelloController {


    @Autowired
    private BusinessClient businessClient;

    @PostMapping("/getObject")
    public Map<String,Object> getObject(){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("1","2");
        return stringObjectHashMap;
    }


    @PostMapping("/testFeign")
    public Map<String,Object> testFeign (){
        Map<String, Object> feign = businessClient.feign();
        return feign;
    }

}
