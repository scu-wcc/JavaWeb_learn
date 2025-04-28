package org.example.aop;



import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Slf4j
//@Aspect
public class LinkNodeAspect {

    @Pointcut("execution(* org.example.service.impl.*.*(..))")
    public void pt() {
    }


    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("LinkNodeAspect 执行前");

        //获取目标类名
        String name = joinPoint.getTarget().getClass().getName();
        log.info("目标类名：{}", name);

        //获取目标方法签名
        Signature signature = joinPoint.getSignature();
        log.info("目标方法签名：{}", signature);

        //获取目标方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("目标方法名：{}", methodName);

        //获取目标方法运行参数
        Object[] args = joinPoint.getArgs();
        log.info("目标方法运行参数：{}", Arrays.toString(args));

        //执行原始目标，获取返回值
        Object result = joinPoint.proceed();

        //原始目标方法返回值
        log.info("目标返回值：{}", result);

        return result;
    }


}
