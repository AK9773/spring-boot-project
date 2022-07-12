package com.zensar.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.demo.entity.Student;
@RestController
@RequestMapping("/student-api")
public class StudentController {
	
	private List<Student> students = new ArrayList<Student>();

	public StudentController() {
		super();
		students.add(new Student(101, "Sam", 28));
		students.add(new Student(102, "Harry", 25));
		students.add(new Student(103, "Jack", 21));
	}





	@RequestMapping(value ="/students/{studentId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Student getStudent(@PathVariable("studentId") int studentId) {
		for (Student student : students) {
			if (student.getStudentId() == studentId) {
				return student;
			}

		}
		return null;

	}

	
	
	
	
	//@RequestMapping(value = "/students", method = RequestMethod.GET)  //Traditional way
	@GetMapping(value = "/students",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Student> getAllStudents() {
		return students;
		
	}

	
	
	
	
	
	//@RequestMapping(value = "/students", method = RequestMethod.POST)
	@PostMapping(value = "/students", consumes ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void insertStudents(@RequestBody Student student) {
		students.add(student);
	}

	
	
	
	
	
	//@RequestMapping(value = "/students/{studentId}", method = RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}",consumes ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public void updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
		Student student2 = getStudent(studentId);
		student2.setStudentId(student.getStudentId());
		student2.setStudentName(student.getStudentName());
		student2.setStudentAge(student.getStudentAge());
		//students.add(student2);
	}
		

	
	
	
	
	@RequestMapping(value = "/students/{studentId}", method = RequestMethod.DELETE)
	//@DeleteMapping("/students/{studentId}")
	public void delete(@PathVariable("studentId") int studentId) {
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			if (student.getStudentId() == studentId) {
				students.remove(student);
			}
		}
		
	}
}
