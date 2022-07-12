package com.zensar.demo.controllers;

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

import com.zensar.demo.dto.StudentDto;
import com.zensar.demo.entity.Student;
import com.zensar.demo.service.StudentServices;

@RestController
@RequestMapping(value = "/student-api",consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class StudentController {

	@Autowired
	private StudentServices studentServices;

	@RequestMapping(value = "/students/{studentId}",method = RequestMethod.GET)
	
	public StudentDto getStudent(@PathVariable("studentId") int studentId) {
		return studentServices.getStudent(studentId);

	}

	// @RequestMapping(value = "/students", method = RequestMethod.GET)
	// //Traditional way
	@GetMapping(value = "/students")
	public List<StudentDto> getAllStudents() {
		return studentServices.getAllStudents();

	}

	// @RequestMapping(value = "/students", method = RequestMethod.POST)
	@PostMapping(value = "/students")
	public StudentDto insertStudents(@RequestBody StudentDto studentDto) {
		return studentServices.insertStudents(studentDto);
	}

	// @RequestMapping(value = "/students/{studentId}", method = RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}")
	public StudentDto updateStudent(@PathVariable("studentId") int studentId, @RequestBody StudentDto studentDto) {
		return studentServices.updateStudent(studentId, studentDto);

	}

	// @RequestMapping(value = "/students/{studentId}", method =
	// RequestMethod.DELETE)
	@DeleteMapping("/students/{studentId}")
	public void deleteStudent(@PathVariable("studentId") int studentId) {
		System.out.println(studentId);
		studentServices.deleteStudent(studentId);

	}
}
