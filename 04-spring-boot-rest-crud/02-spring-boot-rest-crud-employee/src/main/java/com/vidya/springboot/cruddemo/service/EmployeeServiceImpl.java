package com.vidya.springboot.cruddemo.service;

import com.vidya.springboot.cruddemo.dao.EmployeeDAO;
import com.vidya.springboot.cruddemo.dao.EmployeeDAOImpl;
import com.vidya.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
//   employeedao field for injection
    private EmployeeDAO employeeDAO;

//    constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO=theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
          employeeDAO.deleteById(theId);
    }
}
