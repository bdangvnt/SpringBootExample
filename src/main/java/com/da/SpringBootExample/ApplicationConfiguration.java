package com.da.SpringBootExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.da.SpringBootExample.services.EmployeeService;
import com.da.SpringBootExample.services.EmployeeServiceImpl;

@Configuration
public class ApplicationConfiguration {
	@Bean
	public AppProperties appProperties() {
		return new AppProperties();
	}

	@Bean
	public EmployeeService employeeService() {
		return new EmployeeServiceImpl();
	}
}
