package com.arbalax.aopdemo.aspect;

import com.arbalax.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.arbalax.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;

        logger.info("\n====>>> Duration: " + duration / 1000.0 + " seconds");

    return result;
    }





    @After("execution(* com.arbalax.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @After (finally) on method: " + method);

    }



    @AfterThrowing(
            pointcut = "execution(* com.arbalax.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint joinPoint, Throwable exc){

        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @AfterThrowing on method: " + method);

        logger.info("\n====>>> The exception is: " + exc);
    }



    @AfterReturning(
            pointcut = "execution(* com.arbalax.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(
            JoinPoint joinPoint, List<Account> result
    ) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====>>> Executing @AfterReturning on method: " + method);

        logger.info("\n====>>> result is: " + result);

        // post-process the data ... modify it

        convertAccountNamesToUpperCase(result);

        logger.info("\n====>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for (Account account:result){

            // get uppercase version of name
            String theUpperName = account.getName().toUpperCase();

            // update the name on the account
            account.setName(theUpperName);
        }


    }


    @Before("com.arbalax.aopdemo.aspect.ArbAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {

        logger.info("\n=====>>> Executing @Before advice on method addAccount()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: " + methodSignature);

        Object [] args = joinPoint.getArgs();

        for (Object tempArg : args) {
            logger.info(tempArg.toString());

            if (tempArg instanceof Account) {
                Account account = (Account) tempArg;

                logger.info("account name: " + account.getName());
                logger.info("account level: " + account.getLevel());
            }
        }



    }

}
