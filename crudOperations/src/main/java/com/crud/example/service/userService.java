package com.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.crud.example.entity.user;
import com.crud.example.repository.UserRepository;

@Service
public class userService {
	
	@Autowired
	private UserRepository repository;
	
	//POST 
	public user saveUser(user user) {
		return repository.save(user);
	}
	
	public List<user> saveAllUsers(List<user> users) {
		return repository.saveAll(users);
	}
	
	//GET
	public List<user> getUsers(){
		return repository.findAll();
	}
	
	public user getUserById(int id){
		return repository.findById(id).orElse(null);
	}
	
	//DELETE
	
	public String deleteUser(int id) {
		repository.deleteById(id);
		return "User Deleted!! "+id;
	}
	
	//UPDATE
	public user updateUser(user user) {
		user existingUser= repository.findById(user.getId()).orElse(null);
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAddress(user.getAddress());
		existingUser.setNumber(user.getNumber());
		return repository.save(existingUser);
	}
	
	//SORTING
	public List<user> findUserWithSorting(String field){
		
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
		
	}
	
	//PAGINATION
	
	public Page<user> findUserWithPagination(int offset,int pageSize){
		 
		Page<user> users = repository.findAll(PageRequest.of(offset, pageSize));
		return users;
		
	}
	
}
