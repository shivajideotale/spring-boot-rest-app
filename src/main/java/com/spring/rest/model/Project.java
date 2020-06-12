package com.spring.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.web.bind.annotation.Mapping;

@Entity
public class Project {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name="project_Id")
	private int projectId;
	private String projectName;
	private String projectDetails;
	
	@ManyToOne
	private Employee employee;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Project(int projectId, String projectName, String projectDetails, int empId) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDetails = projectDetails;
		this.employee = new Employee(empId,"","");
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectDetails=" + projectDetails
				+ "]";
	}
}
