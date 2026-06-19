package com.example.librarymanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Library {
	@Id
	private int id;
	private String name;
	private String author;
	private String category;
	private double price;
	private int copies;
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public String getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}
	public int getCopies() {
		return copies;
	}
	@Override
	public String toString() {
		return this.id+" "+this.name+" "+this.author+" "+this.category+" "+this.price+" "+this.copies;
	}
}
