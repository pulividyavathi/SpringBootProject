package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
//    setup logger
    private Logger myLogger= Logger.getLogger(getClass().getName());

//    setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPackage(){

    }

//    for service package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePackage(){

    }

//    for dao package
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){

    }

//    combine all
    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){

    }

     @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
//        display method we are calling
         String method=theJoinPoint.getSignature().toShortString();
         System.out.println("====> in @Before: calling method "+method);

//         display the arguments to the method

//         get the arguments
         Object[] args=theJoinPoint.getArgs();

//         loop through and display the args
         for(Object tempArg:args){
             myLogger.info("==== argument: "+tempArg);

         }
     }

     @AfterReturning(
             pointcut = "forAppFlow()",
             returning = "theResult"
     )
    public void AfterReturning(JoinPoint theJoinPoint,Object theResult){
         //        display method we are calling
         String method=theJoinPoint.getSignature().toShortString();
         System.out.println("====> in @After Returning: calling method "+method);

//         display returned
         myLogger.info("====>>> result: "+theResult);

     }



}
