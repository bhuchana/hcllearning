package com.learning.batch.springbatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learning.batch.springbatch.model.Customer;
import com.learning.batch.springbatch.repository.CustomerRepository;

@Component
public class DBWriter implements ItemWriter<Customer>{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void write(List<? extends Customer> customers) throws Exception {
		System.out.println("data saved in db"+customers);
		customerRepository.saveAll(customers);
		
	}

}
