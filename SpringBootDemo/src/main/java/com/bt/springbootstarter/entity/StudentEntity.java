package com.bt.springbootstarter.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="STUDENT_INFO")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fName;

    private String lName;

    private String course;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "studentEntity")
    private List<AddressEntity> addressEntities = new ArrayList<>();


    public StudentEntity() {
    }

    public List<AddressEntity> getAddressEntities() {
        return addressEntities;
    }

    public void setAddressEntities(List<AddressEntity> addressEntities) {
        this.addressEntities.clear();

        for (AddressEntity address: addressEntities) {
            address.setStudentEntity(this);
            this.addressEntities.add(address);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
