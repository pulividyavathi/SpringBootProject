package com.vidya.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(1)
public class MyCloudLogAsyncAscpect {
    @Before("com.vidya.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudSync(){
        System.out.println("\n===>log to cloud sync");
    }

}
