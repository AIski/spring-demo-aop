package pl.Alski.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {


    @Before("pl.Alski.aopdemo.aspect.AOPExpressions.forDaoPackageNoGettersSetters()")
    // or @Before("execution(* pl.Alski.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>> Executing @Before advice on method().");
    }



}
