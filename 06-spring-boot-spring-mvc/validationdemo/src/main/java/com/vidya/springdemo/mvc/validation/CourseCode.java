package com.vidya.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

//    DEFINE default course code
    public String value() default "LUV";

//    define default error message
    public  String message() default "Must start with LUV";

//    define defalult groups
    public Class<?>[] groups() default {};
//    define default payloads
    public Class<? extends Payload>[] payload() default {};

}
