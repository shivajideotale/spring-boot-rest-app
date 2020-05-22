package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.model.Employee;
import com.spring.rest.model.Project;
import com.spring.rest.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@GetMapping("/all")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
	
	@GetMapping("/employee/{id}/project")
	public List<Project> getProjectByEmpId(@RequestBody Project project, @PathVariable("id") int empId) {
		List<Project> projectList = projectService.getProjectByEmpIdProjects(empId);
		return projectList;
	}
	
	@PostMapping("/employee/{id}/project")
	public void addProject(@RequestBody Project project, @PathVariable("id") int empId) {
		project.setEmployee(new Employee(empId,"",""));
		projectService.addProject(project);
	}
	

}
