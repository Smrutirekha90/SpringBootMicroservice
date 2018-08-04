package com.bt.springbootstarter.services;

import com.bt.springbootstarter.beans.Student;
import com.bt.springbootstarter.repository.StudentRepository;
import com.bt.springbootstarter.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentDaoService{


    private static List<Student> students = new ArrayList<>();
    private static int counter = 5;


    static{
        students.add(new Student(1,"Smruti","Rekha","IT"));
        students.add(new Student(2,"Sandhya","HS","ECE"));
        students.add(new Student(3,"Sameer","Behera","IT"));
        students.add(new Student(4,"Gaurav","Day","ECE"));
        students.add(new Student(5,"Raju","Majhi","IT"));
    }

    public List<Student> findAllStudent(){
        return students;
    }

    public Student saveStudent(Student student){
        if(student.getId()==0){
            student.setId(++counter);
        }
        students.add(student);
        return student;
    }

    public Student findOneStudent(int id){
        for(Student std : students){
            if(std.getId()==id){
                return std;
            }
        }
        return null;
    }
    public Student deleteStudent(int id){
        Iterator<Student> it = students.iterator();
        while(it.hasNext()){
            Student student = it.next();
            if(student.getId()==id){
                it.remove();
                return student;
            }
        }
        return null;
    }

}
