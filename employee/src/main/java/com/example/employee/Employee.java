package com.example.employee;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	private int id;
	private String name;
	private String department;
	private int salary;
	private LocalDate joiningDate;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	public int getId() {
		return id;
	}
	public String getDepartment() {
		return department;
	}
	public LocalDate getJoiningDate() {
		return joiningDate;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return this.id+" "+this.name+" "+this.department+" "+this.salary+" "+this.joiningDate;
	}
}
