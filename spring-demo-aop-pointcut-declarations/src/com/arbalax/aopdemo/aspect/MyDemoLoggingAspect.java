package com.arbalax.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.arbalax.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    // this is where we add all of our related advices for logging

    //let's start with @Before advice

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method addAccount()");
    }

    @Before("forDaoPackage()")
    public void performAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }

}
