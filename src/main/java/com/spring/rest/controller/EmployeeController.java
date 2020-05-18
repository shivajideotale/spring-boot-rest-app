package com.spring.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.model.Employee;
import com.spring.rest.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") int empId) {
		//return employeeService.getEmployeeById(empId);
		return employeeService.getEmployeeById(empId);
	}

	@PostMapping
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@PutMapping(value = "/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable("id") int empId) {
		employeeService.updateEmployee(employee, empId);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteEmployee(@PathVariable("id") int empId) {
		employeeService.deleteEmployee(empId);
	}
}
