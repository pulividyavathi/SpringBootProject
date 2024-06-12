package com.vidya.cruddemo.dao;

import com.vidya.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);
    Student findById(Integer id);
}
