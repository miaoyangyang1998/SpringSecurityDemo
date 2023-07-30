package com.ustc.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Yangyang Miao
 * @date :2023-07-30 22:12:00
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello SpringSecurity";
    }
}
