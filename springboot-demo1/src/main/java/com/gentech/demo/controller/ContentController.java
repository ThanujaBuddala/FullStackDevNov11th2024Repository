package com.gentech.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class ContentController
{
    //http://localhost:8084/welcome
    @GetMapping("/welcome")
    public String sayWelcome()
    {
        return "Welcome to Spring Boot Restful API!!!";
    }
}
