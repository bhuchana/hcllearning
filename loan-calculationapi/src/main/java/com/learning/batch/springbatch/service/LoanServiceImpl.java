package com.learning.batch.springbatch.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.learning.batch.springbatch.dto.LoanDetailInfo;
import com.learning.batch.springbatch.dto.LoanRequest;
import com.learning.batch.springbatch.model.Customer;
import com.learning.batch.springbatch.model.CustomerLoan;
import com.learning.batch.springbatch.repository.CustomerRepository;
import com.learning.batch.springbatch.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	CustomerRepository customerRepository; 
	
	@Autowired
	LoanRepository loanRepository;
	
	@Value("${loan.interest}")
	private Double interest; 
	
	@Override
	public LoanDetailInfo applyLoan(LoanRequest loanRequest, String customerId) {
		
		Optional<Customer> customer = customerRepository.findById(Long.valueOf(customerId));
		LoanDetailInfo loanDetailInfo=null;
		if(customer.isPresent()) {
			CustomerLoan customerLoan = createLoanDetailInfo(loanRequest,customer.get());
			CustomerLoan customerLoan2 = loanRepository.save(customerLoan);
			loanDetailInfo=mapCustomerLoanToLoanDetailInfo(customerLoan2);
			
		}
		
		return loanDetailInfo;
	}

	private LoanDetailInfo mapCustomerLoanToLoanDetailInfo(CustomerLoan customerLoan2) {
		LoanDetailInfo loanDetailInfo=new LoanDetailInfo();
		loanDetailInfo.setLoanId(customerLoan2.getId());
		loanDetailInfo.setTotalLoanAmount(customerLoan2.getTotalLoanAmount());
		loanDetailInfo.setMonthlyEMI(customerLoan2.getMonthlyEMI());
		loanDetailInfo.setNoOfMonths(customerLoan2.getNoOfMonths());
		loanDetailInfo.setLoanAmountBalance(customerLoan2.getLoanAmountBalance());
		loanDetailInfo.setRateOfInterest(customerLoan2.getRateOfInterest());
		loanDetailInfo.setCustomerName(customerLoan2.getCustomer().getName());
		loanDetailInfo.setCustomerId(customerLoan2.getCustomer().getId());
		return loanDetailInfo;
	}

	

	private CustomerLoan createLoanDetailInfo(LoanRequest loanRequest, Customer customer) {
		double totalLoanAmount = loanRequest.getLoanAmount();
		Integer noOfYears = loanRequest.getNoOfYears();
		Double monthlyEMI = calculateEmI(totalLoanAmount,noOfYears);
		CustomerLoan customerLoan=new CustomerLoan();
		customerLoan.setCustomer(customer);
		customerLoan.setTotalLoanAmount(new BigDecimal(totalLoanAmount));
		customerLoan.setLoanAmountBalance(new BigDecimal(totalLoanAmount));
		customerLoan.setMonthlyEMI(new BigDecimal(monthlyEMI));
		customerLoan.setNoOfMonths(noOfYears*12);
		customerLoan.setRateOfInterest(this.interest);
		return customerLoan;
		
	}

	private Double calculateEmI(double totalLoanAmount, Integer noOfYears) {
        
        Double finalIn = interest / (12 * 100); // one month interest 
        Integer noOfMonths = noOfYears * 12; // one month period 
         Double emi = (totalLoanAmount * finalIn * (float)Math.pow(1 + finalIn, noOfMonths))  
                / (float)(Math.pow(1 + finalIn, noOfMonths) - 1); 
         System.out.println(emi);
         
         return emi;
		
	}
	
	
	

}
