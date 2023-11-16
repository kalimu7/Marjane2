package com.brief.marjane2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestRestApi {

    @GetMapping("/test")
    public Map<String,Object> home(){
        return Map.of("message","hello world");
    }

}
