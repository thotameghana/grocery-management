package com.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employees {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private long employeeId;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;

	public Employees() {
		// TODO Auto-generated constructor stub
	}

	public Employees(long employeeId, String name, String email, String password, String role) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId2) {
		this.employeeId = employeeId2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", role=" + role + "]";
	}

}
