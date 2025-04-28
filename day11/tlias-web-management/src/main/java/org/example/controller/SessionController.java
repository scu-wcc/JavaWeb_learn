package org.example.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SessionController {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SessionController .class);

    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response){

        //给响应报文添加cookie
        response.addCookie(new Cookie("login_name","itheima"));

        return Result.success();
    }

    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request){
        //获取请求报文的cookie
        Cookie[] cookies = request.getCookies();

        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login_name")){
                System.out.println(cookie.getValue());
            }
        }
        return Result.success();
    }

    @GetMapping("/s1")
    public Result Session1(HttpSession session){
        log.info("HttpSession-sl:{}",session.hashCode());

        //给当前会话设置一个属性
        session.setAttribute("loginUser","Tom");
        return Result.success();
    }

    @GetMapping("/s2")
    public Result Session2(HttpServletRequest request){
        HttpSession session = request.getSession();
        log.info("HttpSession-sl:{}",session.hashCode());

        Object loginUser = session.getAttribute("loginUser");
        log.info("loginUser:{}",loginUser);

        return Result.success(loginUser);
    }
}
