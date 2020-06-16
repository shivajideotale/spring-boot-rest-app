package com.spring.rest.service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.rest.dao.EmployeeRepository;
import com.spring.rest.exception.EmployeeNotFoundException;
import com.spring.rest.model.Employee;
import com.spring.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public boolean delete(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.delete(employee.get());
			return true;

		} else {
			return false;
		}

	}

}
