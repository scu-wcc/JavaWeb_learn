package scu.wcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 请求处理类
@RestController
public class HelloController {

    //将请求路径与处理请求的方法绑定
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello world!");
        return "Hello world!";
    }

}
