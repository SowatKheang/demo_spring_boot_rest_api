package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class TestController {

    @GetMapping(value="/test")
    public String getTest() {
        return "Hello Spring Boot Rest Api";
    }
    
    
}
