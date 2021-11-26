package com.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.example.entity.user;

public interface UserRepository extends JpaRepository<user,Integer>{

}
