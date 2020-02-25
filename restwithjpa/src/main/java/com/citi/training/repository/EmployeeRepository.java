package com.citi.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.training.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
}
