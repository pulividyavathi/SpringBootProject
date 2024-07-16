package com.vidya.aopdemo.dao;

import com.vidya.aopdemo.Account;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account account,boolean vipFlag)
    {
        System.out.println(getClass()+": Doing my db work account dao");

    }
}
