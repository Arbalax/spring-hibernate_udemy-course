package com.arbalax.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {


    @Before("com.arbalax.aopdemo.aspect.ArbAopExpressions.forDaoPackageNoGetterSetter()")
    public void performAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}
