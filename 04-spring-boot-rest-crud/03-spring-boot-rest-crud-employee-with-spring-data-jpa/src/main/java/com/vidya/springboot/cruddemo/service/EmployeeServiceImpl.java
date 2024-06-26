package com.vidya.springboot.cruddemo.service;

import com.vidya.springboot.cruddemo.dao.EmployeeRepository;
import com.vidya.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
//   employeedao field for injection
    private EmployeeRepository employeeRepository;

//    constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theemployeeRepository)
    {
        employeeRepository=theemployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }
        else{
            throw new RuntimeException("Did not find employee id -"+theId);
        }
        return theEmployee;
    }

    @Override

    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override

    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
