package com.spring.rest.service;

import java.util.List;
import java.util.Optional;

import com.spring.rest.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	Optional<Employee> getEmployeeById(int empId);

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee, int empId);

	void deleteEmployee(int empId);

	List<Employee> getEmployeeByDept(String deptName);
}
