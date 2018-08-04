package com.bt.springbootstarter.controller;

import com.bt.springbootstarter.beans.Student;
import com.bt.springbootstarter.exception.UserNotFoundException;
import com.bt.springbootstarter.services.StudentDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentDaoService studentDaoService;


    @GetMapping("/students")
    public List<Student> retrieveAllStudent(){
        return studentDaoService.findAllStudent();
    }

    @GetMapping("/students/{id}")
    public Resource<Student> retrieveStudent(@PathVariable int id) {
        Student student = studentDaoService.findOneStudent(id);
        if(student==null){
            throw new UserNotFoundException("ID - "+id);
        }
        Resource<Student> resource = new Resource<>(student);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllStudent());
        resource.add(linkTo.withRel("all-students"));
        return resource;
    }

    @PostMapping("/students/addStudent")
    public ResponseEntity<Object> saveStudent(@Valid @RequestBody Student student){

        Student savedStudent = studentDaoService.saveStudent(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PostMapping("/students/newStudent")
    public Student persistStudent(@RequestBody Student student){

        Student savedStudent = studentDaoService.saveStudent(student);

        return savedStudent;

    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        Student student = studentDaoService.deleteStudent(id);
        if(student==null){
            throw new UserNotFoundException("ID - "+id);
        }

    }

}
