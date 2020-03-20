package com.learning.batch.springbatch.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.batch.springbatch.dto.EMIRequest;
import com.learning.batch.springbatch.model.Customer;
import com.learning.batch.springbatch.model.EmiDetail;
import com.learning.batch.springbatch.repository.CustomerRepository;
import com.learning.batch.springbatch.repository.EMIRepository;

@Service
public class EMIServiceImpl implements EMIService {
	
	@Autowired
	private  EMIRepository emiRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String payMonthlyEMi(EMIRequest emiRequest, String customerId) {
		
		EmiDetail emiDetail=new EmiDetail();
		Optional<Customer> optionalCustomer = customerRepository.findById(Long.valueOf(customerId));
		if(optionalCustomer.isPresent()) {
			emiDetail.setCustomer(optionalCustomer.get());
			emiDetail.setEmiAmount(emiRequest.getAmiAmount());
		}
		EmiDetail detail = emiRepository.save(emiDetail);
		return "emi paid successfully";
	}
	
}
