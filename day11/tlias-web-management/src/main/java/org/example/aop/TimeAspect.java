package org.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
//@Aspect //表示该类为AOP类
public class TimeAspect {

    @Around("execution(* org.example.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //原方法运行前执行
        long start = System.currentTimeMillis();

        //执行原方法, 获取原方法的返回值
        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
        Long time = end - start;
        log.info(proceedingJoinPoint.getSignature()+"执行耗时："+time+"ms");

        return result;


    }


}
