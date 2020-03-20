package com.learning.batch.springbatch.service;

import com.learning.batch.springbatch.dto.EMIRequest;

public interface EMIService {
	
	public String payMonthlyEMi(EMIRequest emiRequest, String customerId);

}
