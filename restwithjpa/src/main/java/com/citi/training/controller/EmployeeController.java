package com.citi.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citi.training.domain.Employee;
import com.citi.training.domain.Employees;
import com.citi.training.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@RequestMapping(value = "/{empId}",method = RequestMethod.GET,produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public Employee getEmployee(@PathVariable("empId")int id)
	{
		return service.findEmployee(id).get();
	}
	
	@RequestMapping(method = RequestMethod.GET,produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public Employees getAllEmployees()
	{
		List<Employee> list=service.getAllEmployees();
		Employees employees=new Employees();
		employees.setEmployee(list);
		return employees;
	}
	
	@RequestMapping(method = RequestMethod.POST,produces =  MediaType.TEXT_PLAIN_VALUE,
			consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public String addEmployee(@RequestBody Employee e)
	{
		boolean isAdded=service.addEmployee(e);
		if(isAdded) {
			return "Employee added successfully";
		}
		else {
		return "Error in adding employee";
		}
	}
	
	@RequestMapping(value="/{empId}",method = RequestMethod.PUT,produces =  MediaType.TEXT_PLAIN_VALUE,consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public String updateEmployee(@PathVariable("empId")int id,@RequestBody Employee e)
	{
		boolean isUpdated=service.updateEmployee(id, e);
		if(isUpdated) {
			return "Employee updated successfully";
		}
		else {
			return "Error in updating";
		}
	}
	
	@RequestMapping(value="/{empId}",method = RequestMethod.DELETE,produces =  MediaType.TEXT_PLAIN_VALUE)
	public String removeEmployee(@PathVariable("empId")int id)
	{
		boolean isRemoved= service.removeEmployee(id);
		if(isRemoved) {
			return "Employee removed successfully";
		}
		else {
			return "Error in removing employee";
		}
	}
	
}