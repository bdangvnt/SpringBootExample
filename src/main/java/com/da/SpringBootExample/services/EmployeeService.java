package com.da.SpringBootExample.services;

import java.util.List;

import com.da.SpringBootExample.models.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	Employee findById(int id);

	Employee findByName(String name);

	Boolean addEmployee(Employee employee);

	Boolean updateEmployee(int id, Employee employee);

	Boolean deleteEmployee(int id);
}