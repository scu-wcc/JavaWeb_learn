package com.itheima.config;


import com.itheima.controller.DeptController;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CommonConfig {

    @Bean
    //@Scope("prototype")
    public SAXReader getReader(DeptController deptController){
        System.out.println(deptController);
        return new SAXReader();
    }


}
