package com.itheima;

import com.example.HeaderGenerator;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.itheima.controller.DeptController;
import com.itheima.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class AutowiredTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Gson gson;

    @Test
    public void test1(){

        String json = gson.toJson(Result.success());
        System.out.println(json);
        System.out.println(Result.success());

    }

    @Test
    public void test2(){
        System.out.println(applicationContext.getBean(TokenParser.class));
    }

    @Test
    public void test3(){
        System.out.println(applicationContext.getBean(HeaderParser.class));
    }
    @Test
    public void test4(){
        System.out.println(applicationContext.getBean(HeaderGenerator.class));
    }
}
