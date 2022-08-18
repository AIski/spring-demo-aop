package pl.Alski.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("pl.Alski.aopdemo.aspect.AOPExpressions.forDaoPackageNoGettersSetters()")
    public void logToCloud() {

        System.out.println("\n==========>>> Logging to cloud.");
    }

}
