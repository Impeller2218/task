package com.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.example.entity.course;

public interface courseRepository extends JpaRepository<course,Integer>{

}
