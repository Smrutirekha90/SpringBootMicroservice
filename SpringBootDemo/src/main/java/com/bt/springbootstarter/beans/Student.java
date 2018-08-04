package com.bt.springbootstarter.beans;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@ApiModel(description = "It's a student structure")
public class Student {

    private int id;

    @Size(min = 2,message = "Name should have atleast 2 chars.")
    @ApiModelProperty(notes = "FirstName should be of char 2")
    private String fName;


    private String lName;


    private String course;


    public Student() {
    }

    public Student(String fName, String lName, String course) {
        this.fName = fName;
        this.lName = lName;
        this.course = course;
    }
    public Student(int id,String fName, String lName, String course) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
