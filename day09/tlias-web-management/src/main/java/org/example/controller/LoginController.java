package org.example.controller;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.pojo.Emp;
import org.example.pojo.Result;
import org.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoginController.class);


    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){

        log.info("用户:{}正在登录",emp);

        Emp e = empService.login(emp);

        log.info("返回的用户：{}",e);


        if(e!=null){

            Map<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());

            String jwt = Jwts.builder()
                    .addClaims(claims)
                    .signWith(SignatureAlgorithm.HS256,"itheima")
                    .setExpiration(new Date(System.currentTimeMillis()+1000*3600))
                    .compact();
            return Result.success((Object) jwt);
        }else {
            return Result.error("用户名或密码错误");
        }


    }

}
