package com.example.springbootcrud.controller;

import com.example.springbootcrud.model.Student;
import com.example.springbootcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
	//Display list of students
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAll() {

		return studentService.getAllStudents();
	}
	
	@PostMapping("/student")
	public Student add(@RequestBody Student newStudent) {
		return studentService.add(newStudent);
	}
	
	@PutMapping("/student")
	public Student update(@RequestBody Student updateStudent) {
		return studentService.update(updateStudent);
	}
	
	@DeleteMapping("/student/{id}")
	public String delete(@PathVariable Long id) {
		return studentService.delete(id);
	}
	
}

