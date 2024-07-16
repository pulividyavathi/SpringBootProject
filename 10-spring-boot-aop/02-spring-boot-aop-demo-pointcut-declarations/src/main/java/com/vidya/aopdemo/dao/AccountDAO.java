package com.vidya.aopdemo.dao;

import com.vidya.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account account,boolean vipFlag);

    boolean doWork();

    public String getName();


    public void setName(String name);


    public String getServiceCode();

    public void setServiceCode(String serviceCode) ;

}
