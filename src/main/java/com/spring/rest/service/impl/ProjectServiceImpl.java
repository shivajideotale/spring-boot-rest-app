package com.spring.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.ProjectDao;
import com.spring.rest.model.Project;
import com.spring.rest.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDaoRef;
	
	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectDaoRef.findAll();
	}

	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub
		projectDaoRef.save(project);
	}

	@Override
	public List<Project> getProjectByEmpIdProjects(int empId) {
		// TODO Auto-generated method stub
		return projectDaoRef.findByEmployeeEmpId(empId);
	}

}
