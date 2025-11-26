package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e JOIN e.performanceReviews pr WHERE pr.reviewDate = :reviewDate AND pr.score = :score")
	List<Employee> findByPerformanceScoreAndReviewDate(@Param("reviewDate") Date reviewDate, @Param("score") Integer score);

	@Query("SELECT e FROM Employee e WHERE e.department.id IN :departmentIds")
	List<Employee> findByDepartmentIds(@Param("departmentIds") List<Long> departmentIds);

	@Query("SELECT e FROM Employee e JOIN e.projects p WHERE p.id IN :projectIds")
	List<Employee> findByProjectIds(@Param("projectIds") List<Long> projectIds);
}
