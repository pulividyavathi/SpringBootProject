package com.vidya.aopdemo.aspect;

import com.vidya.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Aspect
@Order(2)
public class MyDemoLoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* com.vidya.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable theExc){

//        print out which method we are advising on
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterThrowing on method "+method);

//        log the exception
        System.out.println("\n====>>> The exception is "+theExc);




    }

//    add a new advice for @after returning on the findaccounts method

    @AfterReturning(
            pointcut = "execution(* com.vidya.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
//        print out which method we are advinsing on
        String method=theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing @AfterReturning on method "+method);

//        print out the results of the method call
        System.out.println("\n====>>> result is "+result);

//        let's post process the data..let's modify it

//        convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

//        print out the results of the method call
        System.out.println("\n====>>> result is "+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
//        loop through constructs
        for(Account tempAccount:result) {

//        get uppercase version of account name
            String theUpperName = tempAccount.getName().toUpperCase();

//        update the name of the account
            tempAccount.setName(theUpperName);
        }
    }

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