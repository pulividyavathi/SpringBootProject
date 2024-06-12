package com.vidya.cruddemo;

import com.vidya.cruddemo.dao.StudentDAO;
import com.vidya.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
//			createMutlipleStudents(studentDAO);
			readStudent(studentDAO);

		};
  }

	private void readStudent(StudentDAO studentDAO) {
//		create a student object

		System.out.println("Creating new student object");
		Student tempStudent=new Student( "vikram","Puli","vikram@gmail.com");


//		save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

//		display id of the saved student
		int theId=tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);

//		retrieve student based on the id: primary key
		System.out.println("Retrieving the student with id: "+theId);
		Student myStudent=studentDAO.findById(theId);
//		display the student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMutlipleStudents(StudentDAO studentDAO) {
//		create multiple student objects
		System.out.println("Creating new students objects");
		Student student1=new Student( "Sri","vardhan","sri@gmail.com");
		Student student2=new Student( "priya","sai","priya@gmail.com");
		Student student3=new Student( "Sindhu","val","sindhu@gmail.com");



//		save students objects
		System.out.println("Saving students objects...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
//		display ids of the saved students
		System.out.println("Saved student. Generated id: "+student1.getId());
		System.out.println("Saved student. Generated id: "+student2.getId());
		System.out.println("Saved student. Generated id: "+student3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {

//		create the student object
		System.out.println("Creating new student object");
		Student tempStudent=new Student( "Vidya","Puli","vidya@gmail.com");


//		save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

//		display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}
}










