package com.arbalax.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {


        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        Coach myCoach = context.getBean("tennisCoach", Coach.class);

        //call a method on the bean
        System.out.println(myCoach.getDailyWorkout());

        //call method to get daily fortune
        System.out.println(myCoach.getDailyFortune());
        //close the context
        context.close();
    }
}
