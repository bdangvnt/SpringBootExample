package com.da.SpringBootExample.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.da.SpringBootExample.models.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// @Query("SELECT con FROM Contact con WHERE con.phoneType=(:pType) AND
	// con.lastName= (:lName)")
	// List<Employee> findByLastNameAndPhoneType(@Param("pType") String pType,
	// @Param("lName") String lName);
}
