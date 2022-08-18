package pl.Alski.aopdemo.dao;


import org.springframework.stereotype.Component;
import pl.Alski.aopdemo.Account;

@Component
public class AccountDAO {

    private String name;
    public String serviceCode;


    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println(getClass() +" Doing my DB Work: Adding an account.");
    }
    public void doWork(){
        System.out.println(getClass()+ " Doing my work...");
    }

    public String getName() {
        System.out.println(getClass()+": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
