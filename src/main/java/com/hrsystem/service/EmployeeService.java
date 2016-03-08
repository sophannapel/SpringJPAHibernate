package com.hrsystem.service;

import java.util.List;

import com.hrsystem.model.Employee;

public interface EmployeeService {
	
	Employee save(Employee employee);
	List<Employee> getAll();
}
