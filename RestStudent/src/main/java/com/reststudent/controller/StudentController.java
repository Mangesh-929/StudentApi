package com.reststudent.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reststudent.dao.StudentDao;
import com.reststudent.pojo.Student;
@RestController
public class StudentController {
	@Autowired
	private StudentDao studentdao;
	
	@GetMapping("/getallstudents")
	public List<Student> getAll() {
		List<Student> lst = studentdao.getAllStudents();
		return lst;
	}
	
	@GetMapping("/searchstudent")
	public Student searchStudent(@RequestParam("id") String studentId) {
		
		int studId = Integer.parseInt(studentId);
		
		Student student = studentdao.searchStudent(studId);
		
		return student;
    }
	
	@PostMapping("/addstudent")
     public HashMap<String, String> addStudent(@RequestBody Student stud) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if(studentdao.addNewStudent(stud)) {
			hmap.put("message", "success");
		}
		else {
			hmap.put("message", "failure");
		}
		
		return hmap;
	}
	
	@PutMapping("/updatestudent")
      public HashMap<String, String> updateStudent(@RequestBody Student stud) {
		
		HashMap<String, String> hmap = new HashMap<>();
		
		if(studentdao.updateStudent(stud)) {
			hmap.put("message", "success");
		}
		else {
			hmap.put("message", "failure");
		}
		
		return hmap;
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public HashMap<String, String> deleteStudent(
			@PathVariable("id") String studId) {
		
		int sid = Integer.parseInt(studId);
		HashMap<String, String> hmap = new HashMap<>();
		
		if(studentdao.deleteStudent(sid)) {
			hmap.put("messsage", "success");
		}
		else {
			hmap.put("messsage", "failure");
		}
		
		return hmap;
	}
}
