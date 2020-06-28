package com.spring.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.exception.FieldValidationException;
import com.spring.rest.model.Employee;
import com.spring.rest.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Select, Insert, Delete, Update Operations for an Employee

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = employeeService.findAll();

		if (employees.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new FieldValidationException("FieldException FieldException ", bindingResult);
		}
		Employee savedEmployee = employeeService.save(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		Employee employee = employeeService.findById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.save(employee);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
		Employee deletedEmp = employeeService.delete(id);
		return new ResponseEntity<>(deletedEmp, HttpStatus.OK);

	}

}
