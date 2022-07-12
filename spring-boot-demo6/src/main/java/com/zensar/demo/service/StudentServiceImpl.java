package com.zensar.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.demo.dto.StudentDto;
import com.zensar.demo.entity.Student;
import com.zensar.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServices {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentDto getStudent(int studentId) {
		Student student = studentRepository.findById(studentId).get();
		StudentDto dto = mapToDto(student);
		return dto;

	}

	@Override
	public List<StudentDto> getAllStudents() {

		List<Student> listOfStudents = studentRepository.findAll();
		List<StudentDto> listOfDto = new ArrayList<StudentDto>();
		for (Student student : listOfStudents) {
			StudentDto mapToDto = mapToDto(student);
			listOfDto.add(mapToDto);
		}
		return listOfDto;

	}

	@Override
	public StudentDto insertStudents(StudentDto studentDto) {
		Student student = mapToEntity(studentDto);
		Student newInserted = studentRepository.save(student);
		StudentDto dto = new StudentDto();
		dto.setStudentId(newInserted.getStudentId());
		dto.setStudentAge(newInserted.getStudentAge());
		dto.setStudentName(newInserted.getStudentName());

		return dto;

	}

	@Override
	public StudentDto updateStudent(int studentId, StudentDto studentDto) {
		Student student = mapToEntity(studentDto);
		Student student2 = studentRepository.save(student);
		StudentDto dto = mapToDto(student2);

		return dto;
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
		;
	}

	public Student mapToEntity(StudentDto studentDto) {
		Student student = new Student();
		student.setStudentId(studentDto.getStudentId());
		student.setStudentName(studentDto.getStudentName());
		student.setStudentAge(studentDto.getStudentAge());
		return student;
	}

	public StudentDto mapToDto(Student student) {
		StudentDto dto = new StudentDto();
		dto.setStudentId(student.getStudentId());
		dto.setStudentAge(student.getStudentAge());
		dto.setStudentName(student.getStudentName());
		return dto;
	}
}
