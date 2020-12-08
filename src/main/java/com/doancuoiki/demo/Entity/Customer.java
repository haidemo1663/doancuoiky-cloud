package com.doancuoiki.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Customers")
public class Customer {
	@Id
	private String id;
	private String name;
	private String phone;
	private String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer(String name, String phone, String address) {
		this.name=name;
		this.phone=phone;
		this.address=address;
	}
	public Customer() {
		this.name="";
		this.phone="";
		this.address="";
	}
}
