package com.vidya.aopdemo.aspect;

import com.vidya.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

     @Before("com.vidya.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n====>>> Execution @Before advice on addAccount()");
//        JoinPoint has metadata about method call
//        display the method signature
         MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
         System.out.println("Method "+methodSignature);

//         display method arguments

//         get args
         Object[] args=theJoinPoint.getArgs();

//         loop through args
         for(Object tempArg:args){
             System.out.println(tempArg);
             if(tempArg instanceof Account){
//                 downcast and print account specific stuff
                 Account theAccount=(Account)tempArg;

                 System.out.println("Account name "+theAccount.getName());
                 System.out.println("Account level "+theAccount.getLevel());
             }
         }

    }




}
