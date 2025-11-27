package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.PerformanceReview;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.PerformanceReviewRepository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PerformanceReviewRepository performanceReviewRepository;
	  
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
        Employee employee = employeeRepository.findById(id).orElse(null);
        
        if (employee != null) {
            //EmployeeDTO employeeDTO = convertToDto(employee);
            Set<PerformanceReview> latestReviews = performanceReviewRepository.findTop3ByEmployeeIdOrderByReviewDateDesc(id);
			/*
			 * List<PerformanceReviewDTO> latestReviewDTOs = latestReviews.stream()
			 * .map(this::convertPerformanceReviewToDto) .collect(Collectors.toList());
			 * employeeDTO.setPerformanceReviews(latestReviewDTOs); return employeeDTO;
			 */
            employee.setPerformanceReviews(latestReviews);
            return employee;
        }

        return null;
    }
}
