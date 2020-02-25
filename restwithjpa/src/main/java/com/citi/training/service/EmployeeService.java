package com.citi.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citi.training.domain.Employee;
import com.citi.training.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public Optional<Employee> findEmployee(int id) {
		return repository.findById(id);
	}

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	public boolean updateEmployee(int id, Employee e) {
		Optional<Employee> opt = repository.findById(id);
		if (opt.isPresent()) {
			e.setId(id);
			repository.save(e);
			return true;
		}
		return false;
	}

	public boolean addEmployee(Employee e) {

		repository.save(e);

		return true;

	}

	public boolean removeEmployee(int id) {
		Optional<Employee> emp = repository.findById(id);
		if (emp.isPresent()) {
			repository.delete(emp.get());
			return true;
		}
		return false;

	}
}
