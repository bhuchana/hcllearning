package com.learning.batch.springbatch.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_loan")
public class CustomerLoan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="loan_id")
	private Long id;
	
	@Column(name="total_loan_amount")
	private BigDecimal totalLoanAmount;
	
	@Column(name="no_of_months")
	private Integer noOfMonths;
	
	@Column(name="rate_of_interest")
	private  Double rateOfInterest;
	
	@Column(name="monthly_emi")
	private BigDecimal monthlyEMI;
	
	@Column(name="loan_amount_balance")
	private BigDecimal loanAmountBalance;
	
	@OneToOne
	@JoinColumn(name="customer_id",nullable=false)
	Customer customer;
	
	public CustomerLoan() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotalLoanAmount() {
		return totalLoanAmount;
	}

	public void setTotalLoanAmount(BigDecimal totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}

	public Integer getNoOfMonths() {
		return noOfMonths;
	}

	public void setNoOfMonths(Integer noOfMonths) {
		this.noOfMonths = noOfMonths;
	}

	public Double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public BigDecimal getMonthlyEMI() {
		return monthlyEMI;
	}

	public void setMonthlyEMI(BigDecimal monthlyEMI) {
		this.monthlyEMI = monthlyEMI;
	}

	public BigDecimal getLoanAmountBalance() {
		return loanAmountBalance;
	}

	public void setLoanAmountBalance(BigDecimal loanAmountBalance) {
		this.loanAmountBalance = loanAmountBalance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
