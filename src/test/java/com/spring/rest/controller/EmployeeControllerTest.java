package com.spring.rest.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.rest.exception.EmployeeNotFoundException;
import com.spring.rest.model.Employee;
import com.spring.rest.service.EmployeeService;

@WebMvcTest(controllers = EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	private List<Employee> employees;

	@BeforeEach
	void setUp() {
		this.employees = new ArrayList<Employee>();
		this.employees.add(new Employee());
		this.employees.add(new Employee());

	}

	@Test
	void shouldFetchAllEmployees() throws Exception {

		when(employeeService.findAll()).thenReturn(employees);

		this.mockMvc.perform(get("/api/employee")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(employees.size())));
	}

	@Test
	void shouldFetchOneEmployeeById() throws Exception {

		final int userId = 1;
		final Employee employee = new Employee();
		employee.setEmpno(7369);
		employee.setName("SMITH");

		when(employeeService.findById(userId)).thenReturn(employee);

		this.mockMvc.perform(get("/api/employee/{id}", userId)).andExpect(status().isOk())
				.andExpect(jsonPath("$.empno", is(employee.getEmpno())))
				.andExpect(jsonPath("$.name", is(employee.getName())));
	}

	@Test
	void shouldReturn404WhenFindUserById() throws Exception {
		final int userId = 1;
		when(employeeService.findById(userId)).thenThrow(new EmployeeNotFoundException(userId));

		this.mockMvc.perform(get("/api/employee/{id}", userId)).andExpect(status().isNotFound())
				.andExpect(jsonPath("$.errorMessage", is("Employee id not found : " + userId)))
				.andExpect(jsonPath("$.path", is("/api/employee/" + userId)))
				.andExpect(jsonPath("$.statusCode", is(101)));
	}

	@Test
	void shouldCreateNewEmployee() throws Exception {

		Employee employee = new Employee();
		employee.setName("SMITH");
		employee.setJob("CLERK");
		employee.setDeptno("20");

		when(employeeService.save(Mockito.any(Employee.class))).thenReturn(employee);

		this.mockMvc
				.perform(post("/api/employee").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(new ObjectMapper().writeValueAsString(employee)))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.name", is(employee.getName())))
				.andExpect(jsonPath("$.job", is(employee.getJob())))
				.andExpect(jsonPath("$.deptno", is(employee.getDeptno())));
	}

	@Test
	void shouldCreateNewEmployeeFieldValidationException() throws Exception {

		Employee employee = new Employee();
		employee.setJob("CLERK");
		employee.setDeptno("20");

		when(employeeService.save(Mockito.any(Employee.class))).thenReturn(employee);

		this.mockMvc
				.perform(post("/api/employee").contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(new ObjectMapper().writeValueAsString(employee)))
				.andExpect(status().isBadRequest()).andExpect(jsonPath("$.errors[0].field", is("name")))
				.andExpect(jsonPath("$.errors[0].message", is("Employee name Should not be empty")));
	}

	@Test
	void shouldDeleteUser() throws Exception {

		final int empId = 1;
		final Employee employee = new Employee();
		employee.setEmpno(empId);
		employee.setName("SMITH");
		employee.setJob("CLERK");
		employee.setDeptno("20");

		when(employeeService.delete(empId)).thenReturn(employee);

		this.mockMvc.perform(delete("/api/employee/{id}", empId)).andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(employee.getName())))
				.andExpect(jsonPath("$.job", is(employee.getJob())))
				.andExpect(jsonPath("$.deptno", is(employee.getDeptno())));

	}

	@Test
	void shouldReturn404WhenDeletingNonExistingUser() throws Exception {
		final int empId = 1;

		when(employeeService.delete(empId)).thenThrow(new EmployeeNotFoundException(empId));

		this.mockMvc.perform(delete("/api/employee/{id}", empId)).andExpect(status().isNotFound());

	}

}
