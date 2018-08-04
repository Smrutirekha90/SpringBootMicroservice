package com.bt.springbootstarter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name ="ADDRESS")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ROOM_NO")
    private Integer roomNum;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private StudentEntity studentEntity;

    public AddressEntity() {
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                "roomNum=" + roomNum +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
