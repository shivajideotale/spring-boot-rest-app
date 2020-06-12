package com.spring.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.rest.model.Project;

@Service
public interface ProjectService {

	List<Project> getAllProjects();

	void addProject(Project project);

	List<Project> getProjectByEmpIdProjects(int empId);

}
