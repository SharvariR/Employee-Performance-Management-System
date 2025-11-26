package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByPerformanceScoreAndReviewDate(Date reviewDate, Integer score) {
        return employeeRepository.findByPerformanceScoreAndReviewDate(reviewDate, score);
    }

    public List<Employee> getEmployeesByDepartmentIds(List<Long> departmentIds) {
        return employeeRepository.findByDepartmentIds(departmentIds);
    }

    public List<Employee> getEmployeesByProjectIds(List<Long> projectIds) {
        return employeeRepository.findByProjectIds(projectIds);
    }

    public Employee getEmployeeDetailsById(Long id) {
    	System.out.println("id : service" + id);
        return employeeRepository.findById(id).orElse(null);
    }
}
