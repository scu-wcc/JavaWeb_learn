package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// @SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
   public void genJwt(){
        Map<String,Object> claims = new HashMap<>();

        claims.put("id",1);
        claims.put("username","Tom");

        String jwt = Jwts.builder() //生成JWT令牌
                .setClaims(claims) //指定有效载体
                .signWith(SignatureAlgorithm.HS256,"scuwcc") //指定签名算法和密钥
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000)) // 设置令牌有效期
                .compact(); //生成令牌

        System.out.println(jwt);
    }

    @Test
    public void parseJWT(){

        Claims claims = Jwts.parser()
                .setSigningKey("scuwcc")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzQ1NDkwODYzLCJ1c2VybmFtZSI6IlRvbSJ9.RPIYvs_dAgNTImlOjMHiueLtPyNqDZOmD5jlZRl40ZQ")
                .getBody();

        System.out.println(claims);

    }

}
