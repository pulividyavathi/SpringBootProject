package com.vidya.springdemo.mvc;

import com.vidya.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1,message="is required")
    private String lastName;

 @Min(value = 0,message = "must be greater than or equal to zero")
 @Max(value = 10,message = "must be less than 10")
 @NotNull(message = "is required")
    private Integer freePasses;

 @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "only 5 char/digits")
   private String postalCode;

 @CourseCode(value = "TOPS",message = "must start with TOPS")
  private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
