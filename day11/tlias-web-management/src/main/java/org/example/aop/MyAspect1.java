package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
@Slf4j
public class MyAspect1 {

    @Pointcut("execution(* org.example.service.impl.*.*(..))")
    public void pt(){};


    @Before("pt()")
    public void before(){
        log.info("before方法执行了......");
    }

    @After("pt()")
    public void after(){
        log.info("after方法执行了......");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around方法执行在目标方法之前......");
        Object result = proceedingJoinPoint.proceed();

        log.info("around方法执行在目标方法之后......");

        return result;
    }

    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("AfterReturning方法执行了......");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("AfterThrowing方法执行了......");
    }

}
