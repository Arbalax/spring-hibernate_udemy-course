package com.arbalax.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {


        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from spring container
        SwimCoach myCoach = context.getBean("swimCoach", SwimCoach.class);

        //call a method on the bean
        System.out.println(myCoach.getDailyWorkout());

        //call method to get daily fortune
        System.out.println(myCoach.getDailyFortune());

        // call our new methods ... has the props values injected
        System.out.println("email: " + myCoach.getEmail());
        System.out.println(("team: " + myCoach.getTeam()));

        //close the context
        context.close();
    }
}
