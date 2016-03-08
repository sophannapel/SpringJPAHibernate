package com.hrsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsystem.model.Employee;
import com.hrsystem.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/getAllEmployee", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployee() {
		List<Employee> list = employeeService.getAll();
		return list;
	}

	@RequestMapping(value = { "/", "/addemployee" }, method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", employeeService.getAll());
		return "addemployee";
	}

	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
		if (result.hasErrors()) {
			return "addemployee";
		}
		employeeService.save(employee);
		return "redirect:addemployee";
	}
}
