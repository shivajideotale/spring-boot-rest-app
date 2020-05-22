package com.spring.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.EmployeeDao;
import com.spring.rest.model.Employee;
import com.spring.rest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//List<Employee> employeeList = new ArrayList<>(Arrays.asList(new Employee(1, "Sagar"), new Employee(2, "Preeti")));
	
	@Autowired
	EmployeeDao employeeDaoRef;
	
	@Override
	public List<Employee> getAllEmployees() {

		//return employeeList;
		return employeeDaoRef.findAll();
	}
	
	@Override
	public Optional<Employee> getEmployeeById(int empId) {
		// TODO Auto-generated method stub
		return employeeDaoRef.findById(empId);
	}

	//@Override
	//public List<Employee> getEmployeeById(int empId) {
		
		//return employeeList.stream().filter(u -> u.getEmpId() == empId).findFirst().get();

		// User us = userList.get(userId);
		// return us;
		/*
		 * User user = null;
		 * 
		 * for(int i = 0; i < userList.size(); i++) { user = userList.get(i);
		 * if(user.getUserId() == userId) { return user; }//else return user; } return
		 * user;
		 */
		
		//return employeeDaoRef.getEmployeeById(empId);
	//}

	@Override
	public void addEmployee(Employee employee) {

		//employeeList.add(employee);
		employeeDaoRef.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee, int empId) {

		/*
		 * for (int i = 0; i < employeeList.size(); i++) { Employee emp =
		 * employeeList.get(i); if (emp.getEmpId() == empId) { employeeList.set(i,
		 * employee); return; } }
		 */
		employeeDaoRef.saveAndFlush(employee);
	}

	@Override
	public void deleteEmployee(int empId) {

		//employeeList.remove(empId);
		employeeDaoRef.deleteById(empId);
	}

	@Override
	public List<Employee> getEmployeeByDept(String deptName) {
		// TODO Auto-generated method stub
		return employeeDaoRef.findByDeptName(deptName);
	}

	
}
