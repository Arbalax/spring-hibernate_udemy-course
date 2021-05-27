package com.arbalax.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ArbAopExpressions {

    @Pointcut("execution(* com.arbalax.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}

    @Pointcut("execution(* com.arbalax.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.arbalax.aopdemo.dao.*.set*(..))")
    public void setter(){}

    @Pointcut("forDaoPackage()&&!(getter()||setter())")
    public void forDaoPackageNoGetterSetter() {}
}
