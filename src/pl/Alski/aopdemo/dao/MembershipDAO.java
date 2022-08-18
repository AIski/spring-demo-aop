package pl.Alski.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

public String addAccount(){
    System.out.println(getClass()+": Doing Stuff: Adding a membership account.");
    return null;
}
}
