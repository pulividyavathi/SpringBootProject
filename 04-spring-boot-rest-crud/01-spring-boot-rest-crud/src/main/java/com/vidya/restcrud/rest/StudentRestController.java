package com.vidya.restcrud.rest;

import com.vidya.restcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
//    define @PostConstruct to load the student data...this happens only once!
    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();
        theStudents.add(new Student("Vidya","Puli"));
        theStudents.add(new Student("Vardha","pul"));
        theStudents.add(new Student("Vikram","Pulivi"));
    }
//    define endpoint for /student -return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }
//    define endpoing for "/students/{studentId}" -return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
//        just index into the list..keep it simple for now


//        check the student id against the list size
        if((studentId>=theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found-"+studentId);
        }
        return theStudents.get(studentId);
    }

}
