package com.spring.rest.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empno")
	private int empno;
	@NotNull(message = "Employee name Should not be empty")
	private String name;
	private String job;
	private String boss;
	private String hiredate;
	private String salary;
	private String comm;
	private String deptno;

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getBoss() {
		return boss;
	}

	public void setBoss(String boss) {
		this.boss = boss;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public String getDeptno() {
		return deptno;
	}

	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
}
