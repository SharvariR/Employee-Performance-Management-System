package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
    private EmployeeService employeeService;

    @GetMapping("/filter")
    public List<Employee> getEmployeesByFilters(
            @RequestParam(required = false) String reviewDate,
            @RequestParam(required = false) Integer score,
            @RequestParam(required = false) List<Long> departmentIds,
            @RequestParam(required = false) List<Long> projectIds) {

        if (reviewDate != null && score != null) {
        	 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	 Date date=null;
             try {
                 date = dateFormat.parse(reviewDate);
             } catch (ParseException e) {
                 e.printStackTrace();
             }
            return employeeService.getEmployeesByPerformanceScoreAndReviewDate(date, score);
        } else if (departmentIds != null && !departmentIds.isEmpty()) {
            return employeeService.getEmployeesByDepartmentIds(departmentIds);
        } else if (projectIds != null && !projectIds.isEmpty()) {
            return employeeService.getEmployeesByProjectIds(projectIds);
        } else {
            return List.of();
        }
    }

    @GetMapping("/{id}")
    public Employee getEmployeeDetails(@PathVariable Long id) {
    	System.out.println("id :" +id);
        Employee e =  employeeService.getEmployeeDetailsById(id);
        System.out.println("e :" + e.getName());
        return e;
    }
}
