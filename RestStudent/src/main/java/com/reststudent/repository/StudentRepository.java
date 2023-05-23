package com.reststudent.repository;

import org.springframework.data.repository.CrudRepository;

import com.reststudent.pojo.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
