package com.example.onlinefooddelivery;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="food_orders")
public class Order {
	@Id
	private int id;
	private String customer_name;
	private String food_item;
	private int quantity;
	private double total_amount;
	private LocalDate order_date;
	private boolean order_status;
	public void setId(int id) {
		this.id = id;
	}
	public void setFood_item(String food_item) {
		this.food_item = food_item;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	public void setOrder_status(boolean order_status) {
		this.order_status = order_status;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public String getFood_item() {
		return food_item;
	}
	public int getId() {
		return id;
	}
	public LocalDate getOrder_date() {
		return order_date;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public boolean getOrder_Status() {
		return this.order_status;
	}
	@Override
	public String toString() {
		return this.id+" "+this.customer_name+" "+this.food_item+" "+this.quantity+" "+this.total_amount+" "+this.order_date+" "+this.order_status;
	}
}
