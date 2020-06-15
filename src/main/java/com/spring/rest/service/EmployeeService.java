package com.spring.rest.service;

import java.util.List;

import com.spring.rest.model.Employee;

public interface EmployeeService {

	public Employee findById(int id);

	public List<Employee> findAll();

	public Employee save(Employee employee);

	public boolean delete(int id);
}
