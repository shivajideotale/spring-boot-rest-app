package com.spring.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.model.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
