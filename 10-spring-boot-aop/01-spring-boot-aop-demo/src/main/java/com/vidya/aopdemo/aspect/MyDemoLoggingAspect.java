package com.vidya.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyDemoLoggingAspect {
//    this is where we add all of our related advices for logging

//    lets start with an @Before Advice

    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n====>>> Execution @Before advice on addAccount()");
    }

}
