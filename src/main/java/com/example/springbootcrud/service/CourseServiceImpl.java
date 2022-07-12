package com.example.springbootcrud.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.springbootcrud.model.Course;
import com.example.springbootcrud.model.Student;
import com.example.springbootcrud.repository.CourseRepository;
import com.example.springbootcrud.repository.StudentRepository;


@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public List<Course> getAllCourses() {

		List<String> values = Collections.emptyList();

		if( CollectionUtils.isEmpty(values) ) {
			List<Course> courses = courseRepository.findAll();

			return courses;
		}
		return new ArrayList<>();
	}
	
	@Override
	public Course add(Course newCourse) {
		return courseRepository.save(newCourse);
	}
	
	@Override
	public String delete(Long id) {
		try {
			courseRepository.deleteById(id);

		}catch(Exception err) {
			System.out.print(err.toString());
			return "Failed to delete Course with id " + id;
		}
	
		return "Deleted Course with id " + id;
	}
	
	@Override
	public Course update(Course course) {
		if(!courseRepository.existsById(course.getId())) {
			return null;
		}

		return courseRepository.save(course);

	}

}
