package com.bt.springbootstarter.services;

import com.bt.springbootstarter.beans.Student;
import com.bt.springbootstarter.entity.StudentEntity;

import java.util.List;

public interface StudentDao {
    List<StudentEntity> listAll();

    Student getById(Long id);

    Student saveOrUpdate(Student product);

    void delete(Long id);

    //Student saveOrUpdateProductForm(Student productForm);
}
