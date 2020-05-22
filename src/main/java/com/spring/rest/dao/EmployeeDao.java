package com.spring.rest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	List<Employee> findByDeptName(String deptName);
}
