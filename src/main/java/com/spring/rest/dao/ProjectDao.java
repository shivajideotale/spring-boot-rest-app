package com.spring.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.model.Project;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {

	List<Project> findByEmployeeEmpId(int empId);
}
