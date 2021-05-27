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

    @Pointcut("execution(* com.arbalax.aopdemo.dao.*.get*(..))")
    private void getter(){}

    @Pointcut("execution(* com.arbalax.aopdemo.dao.*.set*(..))")
    private void setter(){}

    @Pointcut("forDaoPackage()&&!(getter()||setter())")
    private void forDaoPackageNoGetterSetter() {}

    // this is where we add all of our related advices for logging

    //let's start with @Before advice

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }

}
