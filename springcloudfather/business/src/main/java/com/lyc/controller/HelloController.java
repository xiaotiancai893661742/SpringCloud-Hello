package com.lyc.controller;


import com.lyc.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/business")
public class HelloController {


    @PostMapping("/getObject")
    public Map<String,Object> getObject(){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("1","2");
        return stringObjectHashMap;
    }

    @PostMapping("/feign")
    public Map<String,Object> feign(){
        System.out.println("进来了");
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("data","feign");
        return stringObjectHashMap;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping("/testjdbcTemplate")
    public Object testjdbcTemplate(){
        return jdbcTemplate.queryForList("select * from account");
    }

    @Resource
    private AccountMapper accountMapper;
    @PostMapping("/testMybatis")
    public Object testMybatis(){
        return accountMapper.findAll();
    }
}
