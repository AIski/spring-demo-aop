package pl.Alski.aopdemo.dao;


import org.springframework.stereotype.Component;
import pl.Alski.aopdemo.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    public String serviceCode;

        //add a new method: findAccounts();

    public List<Account> findAccounts(boolean tripWire) {

        // for academic purpose, to simulate an exception:
        if (tripWire){
            throw new RuntimeException("No soup for you!!!");
        }


        List<Account> myAccounts = new ArrayList<>();

        //create sample accounts
        Account temp1 = new Account("Johny", "Silver");
        Account temp2 = new Account("Mykel", "Bronze");
        Account temp3 = new Account("Luke", "Platinum");

        //add them to account list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }


    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " Doing my DB Work: Adding an account.");
    }

    public void doWork() {
        System.out.println(getClass() + " Doing my work...");
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
