package com.ustc.springsecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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

    // 有HR权限的角色才能执行这个方法
    @PreAuthorize("hasRole('HR')")
    @GetMapping("/world")
    public String world() {
        return "Hello World";
    }
}
