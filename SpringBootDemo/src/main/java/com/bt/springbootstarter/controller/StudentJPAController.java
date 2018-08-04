package com.bt.springbootstarter.controller;

import com.bt.springbootstarter.beans.Student;
import com.bt.springbootstarter.entity.AddressEntity;
import com.bt.springbootstarter.entity.StudentEntity;
import com.bt.springbootstarter.exception.UserNotFoundException;
import com.bt.springbootstarter.repository.AddressRepositiry;
import com.bt.springbootstarter.repository.StudentRepository;
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
import java.util.Optional;

@RestController
public class StudentJPAController {

    @Autowired
    StudentDaoService studentDaoService;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepositiry addressRepositiry;


    @GetMapping("/jpa/students")
    public List<StudentEntity> retrieveAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/jpa/students/{id}")
    public Resource<StudentEntity> retrieveStudent(@PathVariable Long id) {
        Optional<StudentEntity> student = studentRepository.findById(id);
        if(!student.isPresent()){
            throw new UserNotFoundException("ID - "+id);
        }
        Resource<StudentEntity> resource = new Resource<>(student.get());
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllStudent());
        resource.add(linkTo.withRel("all-students"));
        return resource;
    }

    @PostMapping("/jpa/students/addStudent")
    public ResponseEntity<Object> saveStudent(@Valid @RequestBody StudentEntity student){

        StudentEntity savedStudent=studentRepository.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PostMapping("/jpa/students/newStudent")
    public Student persistStudent(@RequestBody Student student){

        Student savedStudent = studentDaoService.saveStudent(student);

        return savedStudent;

    }
    @DeleteMapping("/jpa/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);

    }

    @GetMapping("/jpa/students/{id}/addresses")
    public List<AddressEntity> retrieveAllStudent(@PathVariable Long id){
         Optional<StudentEntity> studentEntity=studentRepository.findById(id);
         if(!studentEntity.isPresent()){
             throw new UserNotFoundException("id- "+id);
         }
         return studentEntity.get().getAddressEntities();

    }

    @PostMapping("/jpa/students/{id}/addAddress")
    public ResponseEntity<Object> addAdress(@PathVariable Long id,@RequestBody AddressEntity addressEntity){

        Optional<StudentEntity> studentEntity=studentRepository.findById(id);
        if(!studentEntity.isPresent()){
            throw new UserNotFoundException("id- "+id);
        }
        StudentEntity student = studentEntity.get();

        addressEntity.setStudentEntity(student);
        AddressEntity savedAddress=addressRepositiry.save(addressEntity);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedAddress.getRoomNum()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PostMapping("/jpa/students/addNewStudent")
    public ResponseEntity<Object> addNewStudent(@RequestBody StudentEntity studentEntity){

        StudentEntity savedStudent=studentRepository.save(studentEntity);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

}
