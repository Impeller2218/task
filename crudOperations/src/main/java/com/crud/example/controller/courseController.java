package com.crud.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.entity.course;
import com.crud.example.entity.user;
import com.crud.example.service.courseService;
import com.crud.example.service.userService;

@RestController
public class courseController {
	
	@Autowired
	private courseService service;
	
	@Autowired
	private userService uservice;
	
	//POST
		@PostMapping("/addCourse")
		public course addCourse(@Valid @RequestBody course course) {
			return service.saveCourse(course);
		}
		
		@PostMapping("/addCourses")
		public List<course> addCourses(@Valid @RequestBody List<course> course) {
			return service.saveAllcourses(course);
		}
		
	 //GET
		
		@GetMapping("/courses")
		public List<course> findAllcourses(){
			return service.getCourses();
		}
	  //GetUserPerCourses
		@GetMapping("/course/{id}")
		public course findCourseById(@PathVariable int id) {
			return service.getCourseById(id);
		}
		
		//UPDATE
		
		@PutMapping("/updateCourse")
		public course updateCourse(@RequestBody course course) {
			return service.updateCourse(course);
		}
		
		//DELETE
		
		@DeleteMapping("/deleteCourse/{id}")
		public String deleteCourse(@PathVariable int id) {
			return service.deleteCourse(id);
		}
		
		//MANY-TO-MANY
		
		@PutMapping("enrollment/{courseID}/users/{userID}")
		public course enrollUsertoCourse(
				@PathVariable int courseID,
				@PathVariable int userID
				) {
			course course = service.getCourseById(courseID);
			user user = uservice.getUserById(userID);
			course.enrollUser(user);
			return service.saveCourse(course);
		}
		
}
