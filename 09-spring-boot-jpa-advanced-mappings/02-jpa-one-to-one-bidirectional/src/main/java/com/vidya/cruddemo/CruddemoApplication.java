package com.vidya.cruddemo;

import com.vidya.cruddemo.Entity.Instructor;
import com.vidya.cruddemo.Entity.InstructorDetail;
import com.vidya.cruddemo.dao.AppDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
       @Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};

	   }

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		System.out.println("Deleting the instructorDetail with id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=2;
		InstructorDetail theInstructorDetail=appDAO.findInstructorDetailById(theId);
		System.out.println("Instructor Details "+theInstructorDetail);

		System.out.println("Print the instructor associated"+theInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting the instructor with id: "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=2;
		Instructor theInstructor=appDAO.findInstructorById(theId);
		System.out.println("Finding instructor with id: "+theId);
		System.out.println("Get the associated instructor details "+theInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
//		create the instructor

		Instructor tempInstructor=new Instructor("Vidya","darby","eafsdf");

//		create the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("yout","asf");


		Instructor tempInstructor1=new Instructor("Vidyavathi","asdpf","puli");

//		create the instructor detail
		InstructorDetail tempInstructorDetail1=new InstructorDetail("dfsdfsdfs","sdf");


//		associate the objects

		tempInstructor1.setInstructorDetail(tempInstructorDetail1);

//		save the instructotr
//note this will also save the details object
//		because of cascadeType all
		System.out.println("saving the instructor"+tempInstructor);
		appDAO.save(tempInstructor1);
		System.out.println("Done");

	}
}
