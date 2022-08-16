package pl.Alski.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.Alski.aopdemo.dao.AccountDAO;

public class Main {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        //call the business method
        theAccountDAO.addAccount();

        System.out.println("lets do it again!");

        //call the business method again
        theAccountDAO.addAccount();

        //close the context
        context.close();

    }
}
