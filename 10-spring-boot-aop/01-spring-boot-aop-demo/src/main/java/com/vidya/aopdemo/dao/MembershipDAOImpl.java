package com.vidya.aopdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount()
    {
        System.out.println(getClass()+": Doing my db work in membership account");
    }
}
