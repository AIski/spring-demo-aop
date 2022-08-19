package pl.Alski.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.Alski.aopdemo.service.TrafficFortuneService;

import java.util.logging.Logger;

public class AroundHandleExceptionMain {

    private static Logger myLogger =
            Logger.getLogger(AroundHandleExceptionMain.class.getName());

    public static void main(String[] args) {



        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\n Main program: AroundDemoApp");

        myLogger.info("Calling getFortune");

        // simulate an exception
        boolean tripWire=true;
        String data =theFortuneService.getFortune(tripWire);

        myLogger.info("\n My fortune is: "+data);

        myLogger.info("Finished.");

        //close the context
        context.close();

    }
}
