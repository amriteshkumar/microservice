package com.boa.training.restspringboot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class EmployeeUtility {
	private TreeMap<Integer, Employee> empList=
			new TreeMap<Integer, Employee>();
	
	public EmployeeUtility()
	{
		empList.put(1001, new Employee(1001, "Arvind", "Developer"));
		empList.put(1002, new Employee(1002, "Suresh", "Accountant"));
		empList.put(1003, new Employee(1003, "Deva", "Developer"));
	}
	
	public Employee findEmployee(int id)
	{
		return empList.get(id);
	}
	
	public boolean addEmployee(Employee e)
	{
		int nextId=empList.lastKey()+1;
		e.setEmpId(nextId);
		empList.put(nextId, e);
		return true;
	}
	
	public boolean updateEmployee(int id,Employee e)
	{
		boolean updated=false;
		Employee emp=empList.get(id);
		if(emp!=null) {
			emp.setName(e.getName());
			emp.setDesignation(e.getDesignation());
			updated=true;
		}
		return updated;
	}
	
	public boolean removeEmployee(int id)
	{
		boolean removed=false;
		Employee emp=empList.get(id);
		if(emp!=null) {
			empList.remove(id);
			removed=true;
		}
		return removed;
	}
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> employees=new ArrayList<Employee>(empList.values());
		return employees;
	}
	
}
