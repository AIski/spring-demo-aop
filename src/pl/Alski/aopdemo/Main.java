package pl.Alski.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.Alski.aopdemo.dao.AccountDAO;
import pl.Alski.aopdemo.dao.MembershipDAO;

public class Main {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);



        MembershipDAO theMembershipDAO=
                context.getBean("membershipDAO", MembershipDAO.class);

        //call the membership business method

        theMembershipDAO.addAccount();

        Account myAccount=new Account();

        //call the business method
        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

        //close the context
        context.close();

    }
}
