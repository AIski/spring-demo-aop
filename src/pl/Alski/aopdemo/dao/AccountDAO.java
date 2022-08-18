package pl.Alski.aopdemo.dao;


import org.springframework.stereotype.Component;
import pl.Alski.aopdemo.Account;

@Component
public class AccountDAO {

    private String name


    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass() +" Doing my DB Work: Adding an account.");
    }
    public void doWork(){
        System.out.println(getClass()+ " Doing my work...");
    }
}
