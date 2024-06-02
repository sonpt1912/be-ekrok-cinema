package com.example.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AnnotationConfig {

    @Around("@annotation(EnableWrapResponse)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long initTime = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - initTime;
        System.out.println("============================================================================================================");
        System.out.println("Method Signature is : "+joinPoint.getSignature() );
        System.out.println("Method executed in : " + executionTime + "ms");
        System.out.println("Input Request: " + joinPoint.getArgs()[0]);
        System.out.println("Output Response : " + proceed);
        return proceed;
    }
}
