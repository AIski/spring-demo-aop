package pl.Alski.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("pl.Alski.aopdemo.aspect.AOPExpressions.forDaoPackageNoGettersSetters()")
    public void performApiAnalytics() {

        System.out.println("\n==========>>> Performing API analytics.");
    }

}
