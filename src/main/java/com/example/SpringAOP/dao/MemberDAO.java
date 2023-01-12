package com.example.SpringAOP.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberDAO {

    public boolean addAccounts(AccountDAO accountDAO, boolean isRight, boolean isWrong) {
        System.out.println("Doing some database work for members!");

        return true;
    }

}
