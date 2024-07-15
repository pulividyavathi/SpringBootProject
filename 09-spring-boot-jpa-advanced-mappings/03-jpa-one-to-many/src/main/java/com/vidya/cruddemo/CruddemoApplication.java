package com.vidya.cruddemo;

import com.vidya.cruddemo.Entity.Course;
import com.vidya.cruddemo.Entity.Instructor;
import com.vidya.cruddemo.Entity.InstructorDetail;
import com.vidya.cruddemo.dao.AppDAO;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//            createInstructorWithCourse(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructorByInstructor(appDAO);
			updateCourseByCourse(appDAO);
		};

	   }

	private void updateCourseByCourse(AppDAO appDAO) {
		int theId=10;

//		find the course
		System.out.println("finding the course with id "+theId);
		Course tempCourse=appDAO.findCourseById(theId);

//		update the course
		System.out.println("Updating the course with id "+theId);
		tempCourse.setTitle("Machine Learning");

		appDAO.updateCourse(tempCourse);
		System.out.println("Done!");


	}

	private void updateInstructorByInstructor(AppDAO appDAO) {
		int theId=1;
//		find the instructor
		System.out.println("finding the instructor with id "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);

//		update the instructor
		System.out.println("Updating the instructor with id "+theId);
		tempInstructor.setLastName("Vidya");

		appDAO.updateInstructor(tempInstructor);
		System.out.println("done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor=appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor "+tempInstructor);

// we don't have to set the instructor with courses here, as the method already gives instructor with courses set

//		get the courses
		System.out.println("Fetching the associated courses "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor=appDAO.findInstructorById(theId);

		System.out.println("temp Instructor "+tempInstructor);

		System.out.println("Finding courses for instructor id "+theId);
		List<Course> courses=appDAO.findCoursesByInstructorId(theId);

//		Set the courses -associate the objects
		tempInstructor.setCourses(courses);

//		get the courses
		System.out.println("Fetching the associated courses "+tempInstructor.getCourses());
//		so we do this manually, setting the courses and getting them instead of spring sending them directly with Eager loading
//		we changed it to lazy, gave a query to execute , set the objects and get them. This allows customised retrieving of objects
//		when needed.
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor=appDAO.findInstructorById(theId);

		System.out.println("temp Instructor "+tempInstructor);
		System.out.println("the associated courses "+tempInstructor.getCourses());
		System.out.println("done!");

	}

	private void createInstructorWithCourse(AppDAO appDAO) {
		//		create the instructor

		Instructor tempInstructor=new Instructor("Vidya","darby","eafsdf");

//		create the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("yout","asf");


//		associate the objects

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1=new Course("Air Guitar");
		Course tempCourse2=new Course("Data Science");
//adding courses to the new instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving Instructors "+tempInstructor);
		System.out.println("saving courses "+tempInstructor.getCourses());
//note: this will also save the courses, because of the cascading.persist
		appDAO.save(tempInstructor);
		System.out.println("done");


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
