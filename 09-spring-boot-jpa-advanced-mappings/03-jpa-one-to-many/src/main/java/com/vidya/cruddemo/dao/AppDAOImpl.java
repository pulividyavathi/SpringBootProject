package com.vidya.cruddemo.dao;

import com.vidya.cruddemo.Entity.Course;
import com.vidya.cruddemo.Entity.Instructor;
import com.vidya.cruddemo.Entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

//        get the courses
        List<Course> courses=theInstructor.getCourses();

//        break association of all courses for the instructor
        for(Course tempCourse:courses){
            tempCourse.setInstructor(null);
        }
//        delete the instructor
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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery query=entityManager.createQuery(
                "from Course where instructor.id=:data",Course.class);
        query.setParameter("data",theId);
//        execute the query
        List<Course> courses=query.getResultList();
        return courses;

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query= entityManager.createQuery(
                "select i from Instructor i "
                        + "JOIN FETCH i.courses "+
                        "JOIN FETCH i.instructorDetail "
                        + "where i.id = :data", Instructor.class);
        query.setParameter("data",theId);

//        execute the query
        Instructor instructor=query.getSingleResult();
        return instructor;

    }

    @Override
    @Transactional
    public void updateInstructor(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);

    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class,theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
//        find course with id
        Course tempCourse=entityManager.find(Course.class,theId);
//        remove the course
        entityManager.remove(tempCourse);
    }
}
