package pl.Alski.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.Alski.aopdemo.dao.AccountDAO;

import java.util.List;

public class AfterThrowingMain {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the method to find the account
        List<Account> theAccounts=null;

        try{
            // add a boolean flag to simulate an exception
            boolean tripWire = true;


            theAccounts=theAccountDAO.findAccounts(tripWire);
        }
        catch (Exception exc) {
            System.out.println("\n\n Main Program ... caught exception: " + exc);
        }

        //display the Accounts;
        System.out.println("\n\n Main Program: AfterThrowingMain");
        System.out.println("-----------");
        System.out.println(theAccounts);
        System.out.println("\n");

        //close the context
        context.close();

    }
}
