package com.crud.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.dto.APIResponse;
import com.crud.example.entity.user;
import com.crud.example.service.userService;

@RestController
public class userController {
	
	@Autowired
	private userService service;
	
	//POST
	@PostMapping("/addUser")
	public user addUser(@Valid @RequestBody user user) {
		return service.saveUser(user);
	}
	
	@PostMapping("/addUsers")
	public List<user> addUsers(@Valid @RequestBody List<user> users) {
		return service.saveAllUsers(users);
	}
	
	//GET
	
	@GetMapping("/users")
	public List<user> findAllProducts(){
		return service.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public user findUserById(@PathVariable int id) {
		return service.getUserById(id);
	}
	
	//UPDATE
	
	@PutMapping("/updateUser")
	public user updateUser(@RequestBody user user) {
		return service.updateUser(user);
	}
	
	//DELETE
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}
	
	//SORTING
	@GetMapping("sort/{field}")
	public APIResponse<List<user>> getProductWithSort(@PathVariable String field){
		
		List<user> allUsers = service.findUserWithSorting(field);
		return new APIResponse<>(allUsers.size(),allUsers);
		
	}
	
	//PAGINATION
	@GetMapping("pagination/{offset}/{pageSize}")
	public APIResponse<Page<user>> getPagination(@PathVariable int offset,@PathVariable int pageSize){
		
		Page<user> usersPagination = service.findUserWithPagination(offset, pageSize);
		return new APIResponse<>(usersPagination.getSize(),usersPagination);
		
	}
	
}
