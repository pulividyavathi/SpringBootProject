package com.vidya.aopdemo.dao;

import com.vidya.aopdemo.Account;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AccountDAOImpl implements AccountDAO{


    private String name;

    private String serviceCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println(getClass()+": in setname");

    }

    public String getServiceCode() {
        System.out.println(getClass()+": in getname");
        return serviceCode;

    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": in service code");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        System.out.println("IN find accounts");
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
//        for academic purposes  simulate an exception
        if(tripWire==true){
            throw new RuntimeException("No soup for you");
        }
        List<Account> myAccounts=new ArrayList<>();

//        create a sample accounts
        Account account1=new Account("vidya","silver");
        Account account2=new Account("Vikram","Gold");
        Account account3=new Account("Sri","Bronze");

//        add them to our accounts list
        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);
        System.out.println("In findAccounts with param");
        return myAccounts;
    }

    @Override
    public void addAccount(Account account,boolean vipFlag)
    {
        System.out.println(getClass()+": Doing my db work account dao");

    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+"Do work ");
        return false;
    }
}
