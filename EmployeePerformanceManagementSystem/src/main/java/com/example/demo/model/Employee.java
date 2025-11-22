package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Set;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(unique = true)
	private String email;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	private Date dateOfJoining;
	private Double salary;
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Employee manager;

	@OneToMany(mappedBy = "employee")
	private Set<PerformanceReview> performanceReviews;

	@ManyToMany(mappedBy = "employees")
	private Set<Project> projects;

	// Getters and Setters
}
