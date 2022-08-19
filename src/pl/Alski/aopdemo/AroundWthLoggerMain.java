package pl.Alski.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.Alski.aopdemo.service.TrafficFortuneService;

import java.util.logging.Logger;

public class AroundWthLoggerMain {

    private static Logger myLogger =
            Logger.getLogger(AroundWthLoggerMain.class.getName());

    public static void main(String[] args) {



        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\n Main program: AroundDemoApp");

        myLogger.info("Calling getFortune");
        String data=theFortuneService.getFortune();

        myLogger.info("\n My fortune is: "+data);

        myLogger.info("Finished.");

        //close the context
        context.close();

    }
}
