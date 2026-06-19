package com.example.student;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private int id;
	private String name;
	private String email;
	private String course;
	private int age;
	public void setId(int id) {
		this.id=id;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCourse() {
		return course;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return this.id+" "+this.name+" "+this.age+" "+this.email+" "+this.course;
	}
}
