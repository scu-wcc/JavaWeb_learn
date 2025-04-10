package com.example.MySpringBoot_Demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello方法执行了");
        return "Hello World!";
    }
}
