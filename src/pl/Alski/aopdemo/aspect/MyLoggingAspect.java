package pl.Alski.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.Alski.aopdemo.Account;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
public class MyLoggingAspect {

    @Around("execution(* pl.Alski.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortun(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        //print method we are advising on
        String method=theProceedingJoinPoint.getSignature().toString();
        System.out.println("\n=========>>> Executing @Around on method: "
                +method);

        //get begin timestamp
        long start= System.currentTimeMillis();

        //execute the method
        Object result = theProceedingJoinPoint.proceed();

        //get end timestamp
        long end= System.currentTimeMillis();

        //compute and display the duration
        long duration =end-start;
        System.out.println(("\n=====>>Duration: "+duration/1000.0+" seconds"));


        return result;
    }


    @After("execution(* pl.Alski.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        //print out which method we are advising on
        String method=theJoinPoint.getSignature().toString();
        System.out.println("\n=========>>> Executing @After (finally) on method: "
                +method);
    }

    @AfterThrowing(
            pointcut = ("execution(* pl.Alski.aopdemo.dao.AccountDAO.findAccounts(..))"),
            throwing="theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc){

        //print out which method we are advising on
        String method=theJoinPoint.getSignature().toString();
        System.out.println("\n=========>>> Executing @AfterThrowing on method: "+method);

        //log the exception:
        System.out.println("\n =====>>>>> the exception is: "+theExc);

    }

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut="execution(* pl.Alski.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning="result")
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result) {

        //print out which method we are advising on
        String method=theJoinPoint.getSignature().toString();
        System.out.println("\n=========>>> Executing @AfterReturning on method: "+method);

        //print out the results of the method call
        System.out.println("\n=========>>> result is:" +result);
        
        //lets post-process the data, lets modify it
        
        //convert account names to uppercase
        convertAccountNamestoUpperCase(result);
    }

    private void convertAccountNamestoUpperCase(List<Account> result) {
        // loop through accounts
    for (Account tempAccount : result) {

        //get uppercase version of the name
    String tempName= tempAccount.getName().toUpperCase();

        // update the name on the account
        tempAccount.setName(tempName);
        }

        System.out.println("\n=========>>> Modified result is:" +result);
    }

    @Before("pl.Alski.aopdemo.aspect.AOPExpressions.forDaoPackageNoGettersSetters()")
    // or @Before("execution(* pl.Alski.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n==========>>> Executing @Before advice on method().");


    //display the method signature
MethodSignature methodSig= (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+methodSig);

    // display method arguments
        Object[] args = theJoinPoint.getArgs();

        for (Object obj:args){
            System.out.println(obj);
            if (obj instanceof Account){
                //downcast and print account specific stuff

                Account theAccount= (Account) obj;
                System.out.println("Account name: "+theAccount.getName());
                System.out.println("Account level: "+theAccount.getLevel());
            }
        }

    }

}
