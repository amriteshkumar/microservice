package com.boa.training.restspringboot.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employees {
	private List<Employee> employee;

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public Employees(List<Employee> employee) {
		super();
		this.employee = employee;
	}

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
