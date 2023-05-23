package com.reststudent.dao;

import java.util.List;

import com.reststudent.pojo.Student;

public interface StudentDao {
	List<Student> getAllStudents();
	Student searchStudent(int sid);
	boolean addNewStudent(Student student);
	boolean updateStudent(Student student);
	boolean deleteStudent(int sid);

}
