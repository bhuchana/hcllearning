package com.learning.batch.springbatch.dto;

import javax.validation.constraints.NotNull;

public class LoanRequest {

	@NotNull
	private double loanAmount;
	@NotNull(message = "years should have between 10 to 20")
	private Integer noOfYears;
	
	
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Integer getNoOfYears() {
		return noOfYears;
	}
	public void setNoOfYears(Integer noOfYears) {
		this.noOfYears = noOfYears;
	} 
}
