package com.vidya.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.vidya.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){

    }

//    create a pointcut for getter methods
    @Pointcut("execution(* com.vidya.aopdemo.dao.*.get*(..))")
    private void getter() {
    }


//    create a pointcut for setter methods
    @Pointcut("execution(* com.vidya.aopdemo.dao.*.set*(..))")
    private void setter() {
    }


//    create a pointcut: include package.. exclude getter/setter methods

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}

     @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n====>>> Execution @Before advice on addAccount()");
    }


    @Before("forDaoPackageNoGetterSetter()")
    public void perfromApiAnalytics(){
        System.out.println("\n===>Performing api analytics");
    }


}
