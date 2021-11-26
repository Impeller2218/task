package com.crud.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class user {
	
	@Id
	@GeneratedValue
	int id;
	
	@NotNull(message = "Name is mandatory")
	private String name;
	
	@NotNull
	@Email(message = "Email is mandatory")
	private String email;
	
	@NotNull
	private String address;
	
	@NotNull
	private int number;
	
//	@ManyToMany
//	@JoinTable(
//			name="user_course",
//			joinColumns = @JoinColumn(name="user_id"),
//			inverseJoinColumns = @JoinColumn(name="course_id")
//			)
//	private List<course> course;
	
	@JsonIgnore
	@ManyToMany(mappedBy="enrolledUsers")
	private List<course> users;
	
	
}
