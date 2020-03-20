package com.learning.batch.springbatch.service;

import com.learning.batch.springbatch.dto.LoanDetailInfo;
import com.learning.batch.springbatch.dto.LoanRequest;

public interface LoanService {
	
	public LoanDetailInfo applyLoan(LoanRequest loanRequest, String customerId);

}
