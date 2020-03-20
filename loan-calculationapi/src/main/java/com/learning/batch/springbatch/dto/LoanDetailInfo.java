package com.learning.batch.springbatch.dto;

import java.math.BigDecimal;

public class LoanDetailInfo {

	
	     private Long loanId;
	   	 private BigDecimal totalLoanAmount;
		 private Integer noOfMonths;
		 private  Double rateOfInterest;	
		 private BigDecimal monthlyEMI;
		 private BigDecimal loanAmountBalance;
		 private String customerName;
		 private Long customerId;
		 
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public Long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}
		public LoanDetailInfo() {
			super();
		}
		
		public LoanDetailInfo(Long loanId, BigDecimal totalLoanAmount, Integer noOfMonths, Double rateOfInterest,
				BigDecimal monthlyEMI, BigDecimal loanAmountBalance, String customerName, Long customerId) {
			super();
			this.loanId = loanId;
			this.totalLoanAmount = totalLoanAmount;
			this.noOfMonths = noOfMonths;
			this.rateOfInterest = rateOfInterest;
			this.monthlyEMI = monthlyEMI;
			this.loanAmountBalance = loanAmountBalance;
			this.customerName = customerName;
			this.customerId = customerId;
		}
		public Long getLoanId() {
			return loanId;
		}
		public void setLoanId(Long loanId) {
			this.loanId = loanId;
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
}
