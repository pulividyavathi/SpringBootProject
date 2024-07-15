package com.vidya.cruddemo.dao;

import com.vidya.cruddemo.Entity.Course;
import com.vidya.cruddemo.Entity.Instructor;
import com.vidya.cruddemo.Entity.InstructorDetail;
import com.vidya.cruddemo.Entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void updateInstructor(Instructor tempInstructor);

    void updateCourse(Course course);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void saveCourse(Course course);

    Course findCourseAndReviewByCourseId(int theId);

    Course findCourseAndStudentsByCourseId(int theId);

    Student findStudentAndCourseByStudentId(int theId);

    void update(Student tempStudent);

    void deleteStudentById(int theId);








}
