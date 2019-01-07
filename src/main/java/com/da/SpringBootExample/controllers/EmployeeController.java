package com.da.SpringBootExample.controllers;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.da.SpringBootExample.ApplicationConfiguration;
import com.da.SpringBootExample.models.Employee;
import com.da.SpringBootExample.services.EmployeeService;

@RestController
public class EmployeeController {
	ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");

	@RequestMapping(value = "/employees", method = GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		if (employees.isEmpty()) {
			System.out.println("Employees Not Found!");
			return new ResponseEntity<List<Employee>>(NO_CONTENT);
		} else {
			System.out.println("Employees Found!");
			return new ResponseEntity<List<Employee>>(employees, OK);
		}
	}

	@RequestMapping(value = "/employee", params = "id", method = GET)
	public ResponseEntity<Employee> getById(@RequestParam int id) {
		Employee employee = employeeService.findById(id);
		if (employee == null) {
			System.out.println("Employee ID " + id + " Not Found!");
			return new ResponseEntity<Employee>(NOT_FOUND);
		} else {
			System.out.println("Employee ID " + id + " Found!");
			return new ResponseEntity<Employee>(employee, OK);
		}
	}

	@RequestMapping(value = "/employee", params = "name", method = GET)
	public ResponseEntity<Employee> getByName(@RequestParam String name) {
		Employee employee = employeeService.findByName(name);
		if (employee.getEmid() == 0) {
			System.out.println("Employee Name " + name + " Not Found!");
			return new ResponseEntity<Employee>(NOT_FOUND);
		} else {
			System.out.println("Employee Name " + name + " Found!");
			return new ResponseEntity<Employee>(employee, OK);
		}
	}

	@RequestMapping(value = "/addEmployee", method = POST)
	public ResponseEntity<Void> addEmployee(@RequestBody Employee employee) {
		if (employeeService.addEmployee(employee)) {
			System.out.println("Created New Employee!");
			return new ResponseEntity<Void>(OK);
		} else {
			System.out.println("Can not create new employee!");
			return new ResponseEntity<Void>(BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/updateEmployee", method = PUT)
	public ResponseEntity<Void> updateEmployee(@RequestParam("id") int id, @RequestBody Employee employee) {
		if (employeeService.updateEmployee(id, employee)) {
			System.out.println("Updated Employee with ID " + id);
			return new ResponseEntity<Void>(OK);
		} else {
			System.out.println("Employee ID " + id + " Not Found!");
			return new ResponseEntity<Void>(NOT_FOUND);
		}
	}

	@RequestMapping(value = "/deleteEmployee", method = DELETE)
	public ResponseEntity<Void> deleteEmployee(@RequestParam("id") int id) {
		if (employeeService.deleteEmployee(id)) {
			System.out.println("Deleted Employee with ID " + id);
			return new ResponseEntity<Void>(OK);
		} else {
			System.out.println("Employee ID " + id + " Not Found!");
			return new ResponseEntity<Void>(NOT_FOUND);
		}
	}
}