package com.vidya.cruddemo.dao;

import com.vidya.cruddemo.Entity.Instructor;
import com.vidya.cruddemo.Entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);





}
