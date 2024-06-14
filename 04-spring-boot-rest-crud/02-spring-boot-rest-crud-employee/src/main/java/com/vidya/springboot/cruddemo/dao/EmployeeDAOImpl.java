package com.vidya.springboot.cruddemo.dao;

import com.vidya.springboot.cruddemo.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
//    define field for Entity manager
    private EntityManager entityManager;
//    set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll() {

//        create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);
//        execute query and get result set
        List<Employee> employees=theQuery.getResultList();
//        return the results
        return employees;
    }

    @Override

    public Employee findById(int theId) {
//       get employee
        Employee tempEmployee;
        tempEmployee = entityManager.find(Employee.class,theId);
//        return employee
        return tempEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
//        save employee
           Employee dbEmployee=entityManager.merge(theEmployee);
//           return the dbEmployee
        return dbEmployee; //has the updated info
    }

    @Override
    public void deleteById(int theId) {
//        find employee by id
        Employee employeeToDelete=entityManager.find(Employee.class,theId);
//remove employee
        entityManager.remove(employeeToDelete);

    }
}
//no transactional annotation here as we use in the service layer