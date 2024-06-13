package com.vidya.cruddemo.dao;

import com.vidya.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student thestudent);

//    void delete(Student theStudent);
    void delete(Integer id);

   int deleteAll();



}
