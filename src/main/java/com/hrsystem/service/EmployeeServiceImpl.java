package com.hrsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsystem.model.Employee;
import com.hrsystem.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	

}
