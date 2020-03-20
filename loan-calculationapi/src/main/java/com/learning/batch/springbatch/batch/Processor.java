package com.learning.batch.springbatch.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.learning.batch.springbatch.model.Customer;

@Component
public class Processor implements ItemProcessor<Customer, Customer> {
	
	private static final Map<String, String> GENDER=new HashMap<>();
	public  Processor() {
		GENDER.put("M", "MALE");
		GENDER.put("F", "FEMALE");
		}

	@Override
	public Customer process(Customer customer) throws Exception {
         String gender = customer.getGender();
         customer.setGender(GENDER.get(gender));
         customer.setPan(customer.getPan().toUpperCase());
		return customer;
	}

}
