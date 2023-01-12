package com.example.SpringAOP.dao;

import com.example.SpringAOP.aspect.AOPAspects;
import com.example.SpringAOP.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class AccountDAO{

    public List<Account> listAccounts() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch(Exception ignored) {

        }
        return List.of(
                new Account("Brandon", "Ibanez"),
                new Account("Crandon", "Ibanez"),
                new Account("Drandon", "Ibanez"),
                new Account("Erandon", "Ibanez"),
                new Account("Frandon", "Ibanez")
        );
    }

    public void addAccount(MemberDAO memberDAO, boolean isRight) {
        System.out.println("Doing some database work for accounts!");
    }

    public void getSomething() {
        System.out.println("I got it girl!");
    }

    public void setSomething() {
        System.out.println("I set it girl!");
    }

}
