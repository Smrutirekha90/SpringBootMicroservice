package com.bt.springbootstarter.repository;

import com.bt.springbootstarter.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Long> /*CrudRepository<StudentEntity,Long>*/{
}
