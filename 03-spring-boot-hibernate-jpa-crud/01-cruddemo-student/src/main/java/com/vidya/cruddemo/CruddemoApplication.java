package com.vidya.cruddemo;

import com.vidya.cruddemo.dao.StudentDAO;
import com.vidya.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
  @Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
			createMutlipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);

		};
  }

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println(numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		//		retrieve student based on the id: primary key
		int studentId=3;
		System.out.println("Deleting student with id: "+studentId);
//		Student myStudent=studentDAO.findById(studentId);
//		the above way doesn't work as we get detached instance exception, as the session gets closed and the
//		state of the object becomes detached. 3 states transient, persistent, detached
//		to make a detached instance to persisit use persist(create) or merge(update)
//
// //		delete the student
		studentDAO.delete(studentId);

//		display the list of students after deleting the student with the given student id
		System.out.println("list of students after deleting the student with the given student id");

		queryForStudents(studentDAO);


	}

	private void updateStudent(StudentDAO studentDAO) {
//		retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent=studentDAO.findById(studentId);

//		change first name to manas
		System.out.println("Updating student ..");
		myStudent.setFirstName("manas");
//		update the student
		studentDAO.update(myStudent);

//		display the updated student
		System.out.println("Updated Student");
		System.out.println(myStudent);


	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
//		get a list of students
		List<Student> theStudents=studentDAO.findByLastName("Puli");

//		display list of students
		for(Student stu:theStudents){
			System.out.println(stu);

		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
//		get a list of students
		List<Student> theStudents=studentDAO.findAll();

//		display list of students
		for(Student stu:theStudents){
			System.out.println(stu);

		}

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










