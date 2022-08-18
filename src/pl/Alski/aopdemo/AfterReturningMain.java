package pl.Alski.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.Alski.aopdemo.dao.AccountDAO;

import java.util.List;

public class AfterReturningMain {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the method to find the account
        List<Account> theAccounts=theAccountDAO.findAccounts(false);

        //display the Accounts;
        System.out.println("\n\n Main Program: AfterReturningMain");
        System.out.println("-----------");
        System.out.println(theAccounts);
        System.out.println("\n");

        //close the context
        context.close();

    }
}
