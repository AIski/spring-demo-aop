package pl.Alski.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {
    public String getFortune(){

        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        //return a fortune

        return "Heavy traffic to be expected this morning.";
    }

    public String getFortune(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("Major accident!");
        }

        return getFortune();
    }
}
