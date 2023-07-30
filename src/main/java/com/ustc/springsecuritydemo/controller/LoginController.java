package com.ustc.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author :Yangyang Miao
 * @date :2023-07-30 22:19:00
 */
// 不是RestController，这里要跳转页面
@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "userlogin";
    }

    @GetMapping("/success")
    public String home() {
        return "index";
    }

    @GetMapping("/error")
    public String fail() {
        return "error";
    }
}
