package com.da.SpringBootExample.models;

import javax.persistence.*;

@Entity
@Table
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long emid;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 50, nullable = false)
	private String address;

	@Column(length = 11, nullable = false)
	private String phone;

	@Column(nullable = false)
	private int salary;

	public Employee() {
	}

	public Employee(String name, String address, String phone, int salary) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.salary = salary;
	}

	public long getEmid() {
		return emid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
