package com.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.example.entity.course;
import com.crud.example.repository.courseRepository;

@Service
public class courseService {
	
	@Autowired
	private courseRepository repository;
	
	//POST 
	public course saveCourse(course course) {
		return repository.save(course);
	}
	
	public List<course> saveAllcourses(List<course> courses) {
		return repository.saveAll(courses);
	}
	
	//GET
		public List<course> getCourses(){
			return repository.findAll();
		}
		
		public course getCourseById(int id){
			return repository.findById(id).orElse(null);
		}
		
	//DELETE
		
		public String deleteCourse(int id) {
			repository.deleteById(id);
			return "Course Deleted!! "+id;
		}
	
	//UPDATE
		public course updateCourse(course course) {
			course existingCourse= repository.findById(course.getId()).orElse(null);
			existingCourse.setCourseName(course.getCourseName());
			existingCourse.setCourseDetails(course.getCourseDetails());
			return repository.save(existingCourse);
		}
		
	//ManyToMany
		
		
		
}
