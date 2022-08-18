package pl.Alski.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.Alski.aopdemo.Account;
import pl.Alski.aopdemo.DemoConfig;
import pl.Alski.aopdemo.dao.AccountDAO;
import pl.Alski.aopdemo.service.TrafficFortuneService;

import java.util.List;

public class AroundMain {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\n Main program: AroundDemoApp");

        System.out.println("Calling getFortune");
        String data=theFortuneService.getFortune();

        System.out.println("\n My fortune is: "+data);

        System.out.println("Finished.");

        //close the context
        context.close();

    }
}
