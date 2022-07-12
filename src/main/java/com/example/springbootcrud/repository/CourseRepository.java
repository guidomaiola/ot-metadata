package com.example.springbootcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootcrud.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByCourse(Course c);
	
//	List<Course> countByStudentGreaterThan(int StudentsCount);
}
