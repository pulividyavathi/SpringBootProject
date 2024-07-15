package com.vidya.cruddemo.Entity;

import jakarta.persistence.*;

@Entity
public class Review {
//    create fields, annotate and associate with course class

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comment")
    private String comment;


    @Column(name = "course_id")
    private int courseId;

//     constructors


//    getters and setters
}
