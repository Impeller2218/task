package com.crud.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@NotNull(message = "Name is mandatory")
	private String courseName;
		
	@NotNull(message = "Details is mandatory")
	private String courseDetails;
	
//	 @ManyToMany(mappedBy = "course")
//	    public List<user> user;
	
	@ManyToMany
	@JoinTable(
			name="user_course",
			joinColumns = @JoinColumn(name="course_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<user> enrolledUsers;

	public void enrollUser(user user) {
		enrolledUsers.add(user);
	}
	
}
