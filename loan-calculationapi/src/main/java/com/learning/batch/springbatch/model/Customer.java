package com.learning.batch.springbatch.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@Column(name="customer_id")
	private Long id;
	private String name;
	private String gender;
	private Integer age;
	private String pan;
	private Long aadhar;
	private double salary;
	
	@OneToMany(mappedBy = "customer",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<EmiDetail> emiDetails;
	
	@OneToOne(mappedBy = "customer")
	private CustomerLoan customerLoan;
	
	
	
	

	public Customer(Long id, String name, String gender, Integer age, String pan, Long aadhar, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.pan = pan;
		this.aadhar = aadhar;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Long getAadhar() {
		return aadhar;
	}

	public void setAadhar(Long aadhar) {
		this.aadhar = aadhar;
	}

	
	public Customer() {
		
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<EmiDetail> getEmiDetails() {
		return emiDetails;
	}

	public void setEmiDetails(List<EmiDetail> emiDetails) {
		this.emiDetails = emiDetails;
	}

	public CustomerLoan getCustomerLoan() {
		return customerLoan;
	}

	public void setCustomerLoan(CustomerLoan customerLoan) {
		this.customerLoan = customerLoan;
	}
	
	
	

}
