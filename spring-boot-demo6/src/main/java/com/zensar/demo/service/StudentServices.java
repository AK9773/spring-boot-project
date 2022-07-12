package com.zensar.demo.service;

import java.util.List;

import com.zensar.demo.dto.StudentDto;
import com.zensar.demo.entity.Student;

public interface StudentServices {
	public StudentDto getStudent(int studentId);

	public List<StudentDto> getAllStudents();

	public StudentDto insertStudents(StudentDto studentDto);

	public StudentDto updateStudent(int studentId, StudentDto studentDto);

	public void deleteStudent(int studentId);
}
