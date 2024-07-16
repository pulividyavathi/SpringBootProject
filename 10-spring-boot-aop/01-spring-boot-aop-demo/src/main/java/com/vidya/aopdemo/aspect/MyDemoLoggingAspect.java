package com.vidya.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyDemoLoggingAspect {
//    this is where we add all of our related advices for logging

//    let's start with a @Before Advice

//    @Before("execution(public * add*())")
@Before("execution(* add*(com.vidya.aopdemo.Account,..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n====>>> Execution @Before advice on addAccount()");
    }

}
