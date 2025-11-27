package com.example.demo.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PerformanceReview;

@Repository
public interface PerformanceReviewRepository extends JpaRepository<PerformanceReview, Long>{

	// Custom query method to find the latest three performance reviews for an employee
	@Query(value = "SELECT * FROM performance_review pr WHERE pr.employee_id = :employeeId ORDER BY pr.review_date DESC LIMIT 3", nativeQuery = true)
    Set<PerformanceReview> findTop3ByEmployeeIdOrderByReviewDateDesc(@Param("employeeId") Long employeeId);
}
