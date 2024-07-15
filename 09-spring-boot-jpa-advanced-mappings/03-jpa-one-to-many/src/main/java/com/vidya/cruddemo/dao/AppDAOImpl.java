package com.vidya.cruddemo.dao;

import com.vidya.cruddemo.Entity.Instructor;
import com.vidya.cruddemo.Entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

//    define field for entity manager
    private EntityManager entityManager;
//    inject entity manager using construtor injection

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
       return entityManager.find(Instructor.class,theId);

    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor theInstructor=entityManager.find(Instructor.class,theId);
        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail theInstructorDetail=entityManager.find(InstructorDetail.class,theId);
//       remove the associated object reference
//        break bidirectional link
        theInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(theInstructorDetail);
    }
}
