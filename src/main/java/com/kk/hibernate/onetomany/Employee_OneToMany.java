package com.kk.hibernate.onetomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Employee_OneToMany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "employee")
	private List<Address_OneToMany> address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Address_OneToMany> getAddress() {
		return address;
	}
	public void setAddress(List<Address_OneToMany> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee_OneToMany [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
