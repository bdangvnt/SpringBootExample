package com.da.SpringBootExample.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.da.SpringBootExample.models.Employee;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// @Query("SELECT con FROM employee con WHERE con.phoneType=(:pType) AND
	// con.lastName= (:lName)")
	// List<Employee> findByName(@Param("pType") String pType, @Param("lName")
	// String lName);

	// @Modifying
	// @Query("SELECT con FROM employee as con WHERE con.name LIKE %:name%")
	// List<Employee> filterByName(@Param("name") String name);

	@Query("SELECT e FROM Employee e WHERE e.name LIKE %?1%")
	List<Employee> findByName2(String name);

	List<Employee> findByNameContaining(@Param("name") String name);

	List<Employee> findByName(@Param("lName") String lName);

	// @Query("SELECT con FROM employee con WHERE con.name LIKE (:name)")
	// boolean addEmployee(Employee employee);
}
