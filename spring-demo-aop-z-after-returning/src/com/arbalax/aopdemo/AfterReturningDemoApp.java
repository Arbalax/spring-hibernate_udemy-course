package com.arbalax.aopdemo;

import com.arbalax.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

        // read spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get bean from container

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List <Account> accounts = accountDAO.findAccounts();

        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("----");

        System.out.println(accounts);

        System.out.println("\n");
        //close the context

        context.close();
    }
}
