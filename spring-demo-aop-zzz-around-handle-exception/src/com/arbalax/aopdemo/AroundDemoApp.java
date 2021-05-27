package com.arbalax.aopdemo;

import com.arbalax.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {

        // read spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get bean from container

        TrafficFortuneService trafficFortuneService = context.getBean(
                        "trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundDemoApp");

        System.out.println("Calling getFortune");

        String data = trafficFortuneService.getFortune(false);

        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished");
        context.close();
    }
}
