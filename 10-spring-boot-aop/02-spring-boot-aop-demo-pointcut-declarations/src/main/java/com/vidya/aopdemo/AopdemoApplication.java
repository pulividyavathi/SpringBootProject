package com.vidya.aopdemo;

import com.vidya.aopdemo.dao.AccountDAO;
import com.vidya.aopdemo.dao.MembershipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		return runner -> {

//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			demoTheAfterReturningAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
//		call the method to find the accounts
		List<Account> theAccounts=theAccountDAO.findAccounts();

//		display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		Account myAccount=new Account();
        myAccount.setName("Vidya");
		myAccount.setLevel("2");
		// call the business method
		theAccountDAO.addAccount(myAccount,true);

		// call the membership business method
		theMembershipDAO.addAccount();

		theAccountDAO.doWork();

		theMembershipDAO.goToSleep();

//		call the accountdao getter and setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name=theAccountDAO.getName();
		String code=theAccountDAO.getServiceCode();


	}

}


