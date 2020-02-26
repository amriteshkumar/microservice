package com.boa.training.restspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boa.training.restspringboot.model.Employee;
import com.boa.training.restspringboot.model.EmployeeUtility;
import com.boa.training.restspringboot.model.Employees;

@RestController
@RequestMapping("/emp")
public class EmployeeResource {
	@Autowired
	private EmployeeUtility empUtility;
	
	@GetMapping(value ="/{id}",produces = 
		{ MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Employee> getEmployee(@PathVariable("id")int empId)
	{
		return new ResponseEntity<Employee>(empUtility.findEmployee(empId),HttpStatus.OK);
	}
	
	@PostMapping(produces = MediaType.TEXT_HTML_VALUE,
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> addEmployee(@RequestBody Employee e)
	{
		boolean added=empUtility.addEmployee(e);
		if(added) {
			return new ResponseEntity<String>
			("<html><body><h3>Added successfully</h3></body></html>",HttpStatus.CREATED);
		}
		else {
		return new ResponseEntity<String>
		("<html><body><h3>Error in adding</h3></body></html>",HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(produces = MediaType.TEXT_HTML_VALUE,
			consumes ={ MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},value="/{id}")
	public ResponseEntity<String> modifyEmployee(@RequestBody Employee e,
			@PathVariable("id")int empId)
	{
		boolean updated=empUtility.updateEmployee(empId,e);
		if(updated) {
			return new ResponseEntity<String>
			("<html><body><h3>Updated successfully</h3></body></html>",HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>
		("<html><body><h3>Error in updating</h3></body></html>",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(produces = MediaType.TEXT_HTML_VALUE
			,value = "/{id}")
	public ResponseEntity<String> removeEmployee(@PathVariable("id")int empId)
	{
		boolean removed=empUtility.removeEmployee(empId);
		if(removed) {
			return new ResponseEntity<String>
			("<html><body><h3>Removed successfully</h3></body></html>",HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>
		("<html><body><h3>Error in removing</h3></body></html>",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE
			
	})
	public ResponseEntity<Employees> allEmployeeData()
	{
		Employees employees=new Employees(empUtility.getAllEmployees());
		return new ResponseEntity<Employees>(employees,
				HttpStatus.OK);
	}
	
	
}
