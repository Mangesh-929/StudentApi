package com.reststudent.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reststudent.dao.StudentDao;
import com.reststudent.pojo.Student;
import com.reststudent.repository.StudentRepository;
@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private StudentRepository repository;

	@Override
	public List<Student> getAllStudents() {
		List<Student> lst = new ArrayList<>();
		try {
			repository.findAll().forEach(lst::add);
			return lst;
		}
		catch(Exception e) {
			e.printStackTrace();
			lst.clear();
			return lst;	
		}
	}

	@Override
	public Student searchStudent(int sid) {
		Student student = null;
		try {
			Optional<Student> opt = repository.findById(sid);
			
			if(opt.isPresent()) {
				return opt.get();
			}
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
				
	}

	@Override
	public boolean addNewStudent(Student student) {
		try {
			repository.save(student);
			return true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean updateStudent(Student student) {
		try {
			Optional<Student> opt = repository.findById(student.getSid());
			if(opt.isPresent()) {
				repository.save(student);
				return true;
			}
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int sid) {
		try {
			Optional<Student> opt = repository.findById(sid);
			if(opt.isPresent())
			{
				repository.deleteById(sid);
				return true;
			}
			else
				return false;	
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;	
		}
	}
}
