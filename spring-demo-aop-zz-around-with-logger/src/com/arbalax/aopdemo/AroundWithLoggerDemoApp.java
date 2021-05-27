package com.arbalax.aopdemo;

import com.arbalax.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {

    private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring config java class

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get bean from container

        TrafficFortuneService trafficFortuneService = context.getBean(
                        "trafficFortuneService", TrafficFortuneService.class);

        logger.info("\nMain Program: AroundDemoApp");

        logger.info("Calling getFortune");

        String data = trafficFortuneService.getFortune();

        logger.info("\nMy fortune is: " + data);

        logger.info("Finished");
        context.close();
    }
}
