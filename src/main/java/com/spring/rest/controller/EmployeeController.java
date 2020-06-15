package com.spring.rest.controller;

import com.spring.rest.exception.FieldException;
import com.spring.rest.model.Employee;
import com.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Select, Insert, Delete, Update Operations for an Employee

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {
		return employeeService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Employee addEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new FieldException("FieldException FieldException ", bindingResult);
		}
		Employee savedEmployee = employeeService.save(employee);
		return savedEmployee;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable Integer id) {
		return employeeService.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.save(employee);
		return updatedEmployee;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Map<String, String> deleteEmployee(@RequestParam Integer id) {
		Map<String, String> status = new HashMap<>();
		if (employeeService.delete(id)) {
			status.put("Status", "Employee deleted successfully");
		} else {
			status.put("Status", "Employee not exist");
		}
		return status;
	}

}
