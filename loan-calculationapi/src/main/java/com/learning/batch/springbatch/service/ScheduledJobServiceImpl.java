package com.learning.batch.springbatch.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.batch.springbatch.model.Customer;
import com.learning.batch.springbatch.model.CustomerLoan;
import com.learning.batch.springbatch.model.EmiDetail;
import com.learning.batch.springbatch.repository.CustomerRepository;
import com.learning.batch.springbatch.repository.EMIRepository;
import com.learning.batch.springbatch.repository.LoanRepository;

@Component
public class ScheduledJobServiceImpl implements ScheduledJobService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	LoanRepository loanRepository;
	@Autowired
	EMIRepository emiRepository;
	
	@Override
	public void performEmiJob() {
		
		List<CustomerLoan> customerLoans = loanRepository.findAll();
		List<Customer> customers=customerLoans.
				stream()
				.map(customerLoan ->{
					return customerLoan.getCustomer();
				}).collect(Collectors.toList());
		Map<Long, Double> amountByCustomer=new HashMap<Long, Double>();
		for(Customer customer:customers) {
						
			List<EmiDetail> emiDetails = customer.getEmiDetails();
			Double totalEmi=0.0;
			for(EmiDetail emailDetail:emiDetails) {
				totalEmi=totalEmi+emailDetail.getEmiAmount();
			}
			
			amountByCustomer.put(customer.getId(), totalEmi);
			Optional<CustomerLoan> loanOptional = loanRepository.findById(customer.getCustomerLoan().getId());
			if(loanOptional.isPresent()) {
				CustomerLoan customerLoan = loanOptional.get();
				BigDecimal loanAmountBalance = customerLoan.getLoanAmountBalance();
				loanAmountBalance=loanAmountBalance.subtract(new BigDecimal(totalEmi));
				customerLoan.setLoanAmountBalance(loanAmountBalance);
				System.out.println("total pending emi balance"+loanAmountBalance);
				System.out.println("total loan amount"+customerLoan.getTotalLoanAmount());
				loanRepository.save(customerLoan);
				
			}
			 
			
		}
		
		
		
	}
	
	

}
